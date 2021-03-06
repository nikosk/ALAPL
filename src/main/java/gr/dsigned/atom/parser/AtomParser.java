package gr.dsigned.atom.parser;

import gr.dsigned.atom.domain.AtomCategory;
import gr.dsigned.atom.domain.AtomEntry;
import gr.dsigned.atom.domain.AtomFeed;
import gr.dsigned.atom.domain.AtomLink;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;

public class AtomParser {

    private AtomFeed feed;
    private static final ExecutorService executor = Executors.newFixedThreadPool(3);
    private boolean parseDates = true;
    private final HashMap<String, String> attMap = new HashMap<String, String>();
    protected static final SimpleDateFormat ISO8601_DATE_FORMATS[] = new SimpleDateFormat[]{new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz"), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")};
    private static final String FEED_TAG = "feed";
    private static final String TITLE_TAG = "title";
    private static final String LINK_TAG = "link";
    private static final String SUBTITLE_TAG = "subtitle";
    private static final String ICON_TAG = "icon";
    private static final String UPDATED_TAG = "updated";
    private static final String PUBLISHED_TAG = "published";
    private static final String ENTRY_TAG = "entry";
    private static final String CATEGORY_TAG = "category";
    private static final String ID_TAG = "id";
    private static final String SUMMARY_TAG = "summary";
    private static final String CONTENT_TAG = "content";
    private static final String CONTENT_ENCODED_TAG = "content:encoded";
    private static final String CONTENT_ENCODED_ALT_TAG = "encoded";
    private static final String AUTHOR_TAG = "author";
    private static final String NAME_TAG = "name";

    public AtomFeed parse(final InputStream in, long timeOut) {

        Callable<AtomFeed> task = new Callable<AtomFeed>() {
            public AtomFeed call() throws IOException, XmlPullParserException {
                AtomParser parser = new AtomParser();
                return parser.parse(in);
            }
        };
        AtomFeed result = null;
        Future<AtomFeed> future = executor.submit(task);
        try {
            result = future.get(timeOut, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            future.cancel(true);
        }
        return result;
    }

    public AtomFeed parse(InputStream in) throws XmlPullParserException, IOException {
        feed = new AtomFeed();
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(in, null);
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                String startTag = parser.getName();
                if (FEED_TAG.equals(startTag)) {
                    processFeed(parser);
                }
            }
            eventType = parser.next();
        }
        return feed;
    }

    private void processFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                String startTag = parser.getName();
                if (TITLE_TAG.equals(startTag)) {
                    feed.setFeedTitle(parser.nextText());
                } else if (LINK_TAG.equals(startTag)) {
                    getAttributeMap(parser);
                    if (attMap.containsKey("rel") && attMap.get("rel").equals("alternate")) {
                        feed.setAlternateURL(attMap.get("href"));
                    }
                    if (feed.getLinks() == null) {
                        feed.setLinks(new ArrayList<AtomLink>());
                    }
                    AtomLink link = new AtomLink();
                    link.setHref(attMap.get("href"));
                    link.setRel(attMap.get("rel"));
                    link.setTitle(attMap.get("title"));
                    link.setType(attMap.get("type"));
                    link.setVia(attMap.get("via"));
                    feed.getLinks().add(link);
                } else if (SUBTITLE_TAG.equals(startTag)) {
                    feed.setSubtitle(parser.nextText());
                } else if (ICON_TAG.equals(startTag)) {
                    feed.setIcon(parser.nextText());
                } else if (UPDATED_TAG.equals(startTag)) {
                    String updated = iso8601StringToUTCDateString(parser.nextText());
                    if (parseDates) {
                        try {
                            feed.setUpdated(ISO8601_DATE_FORMATS[0].parse(updated));
                        } catch (ParseException pe1) {
                            try {
                                feed.setUpdated(ISO8601_DATE_FORMATS[1].parse(updated));
                            } catch (ParseException pe2) {
                                try {
                                    feed.setUpdated(ISO8601_DATE_FORMATS[2].parse(updated));
                                } catch (ParseException pe3) {
                                    // no big deal, stay silent
                                }
                            }
                        }
                    }
                    feed.setUpdatedString(updated);
                } else if (ENTRY_TAG.equals(startTag)) {
                    processEntry(parser);
                }

            } else if (eventType == XmlPullParser.END_TAG) {
                String endTag = parser.getName();
                if (FEED_TAG.equals(endTag)) {
                    break;
                }
            }
            eventType = parser.next();
        }
    }

    private void processEntry(XmlPullParser parser) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        AtomEntry entry = new AtomEntry();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                String startTag = parser.getName();
                if (TITLE_TAG.equals(startTag)) {
                    entry.setTitle(parser.nextText());
                } else if (LINK_TAG.equals(startTag)) {
                    getAttributeMap(parser);
                    AtomLink link = new AtomLink();
                    link.setRel(attMap.get("rel"));
                    link.setHref(attMap.get("href"));
                    link.setTitle(attMap.get("title"));
                    link.setType(attMap.get("type"));
                    link.setVia(attMap.get("via"));
                    entry.addLink(link);
                } else if (CATEGORY_TAG.equals(startTag)) {
                    getAttributeMap(parser);
                    AtomCategory cat = new AtomCategory();
                    cat.setLabel(attMap.get("label"));
                    cat.setTerm(attMap.get("term"));
                    entry.addCatogory(cat);
                } else if (AUTHOR_TAG.equals(startTag)) {
                    processAuthor(entry, parser);
                } else if (ID_TAG.equals(startTag)) {
                    entry.setId(parser.nextText());
                } else if (PUBLISHED_TAG.equals(startTag)) {
                    String published = iso8601StringToUTCDateString(parser.nextText());
                    if (parseDates) {
                        try {
                            published = published.trim();
                            entry.setPublished(ISO8601_DATE_FORMATS[0].parse(published));
                        } catch (ParseException pe1) {
                            try {
                                entry.setPublished(ISO8601_DATE_FORMATS[1].parse(published));
                            } catch (ParseException pe2) {
                                try {
                                    entry.setPublished(ISO8601_DATE_FORMATS[2].parse(published));
                                } catch (ParseException pe3) {
                                    // no big deal, stay silent
                                }
                            }
                        }
                    }
                    entry.setPublishedString(published);
                } else if (UPDATED_TAG.equals(startTag)) {
                    String updated = iso8601StringToUTCDateString(parser.nextText());
                    if (parseDates) {
                        try {
                            updated = updated.trim();
                            entry.setUpdated(ISO8601_DATE_FORMATS[0].parse(updated));
                        } catch (ParseException pe1) {
                            try {
                                entry.setUpdated(ISO8601_DATE_FORMATS[1].parse(updated));
                            } catch (ParseException pe2) {
                                try {
                                    entry.setUpdated(ISO8601_DATE_FORMATS[2].parse(updated));
                                } catch (ParseException pe3) {
                                    // no big deal, stay silent
                                }
                            }
                        }
                    }
                    entry.setUpdatedString(updated);
                } else if (SUMMARY_TAG.equals(startTag)) {
                    entry.setSummary(parser.nextText());
                } else if (CONTENT_ENCODED_TAG.equals(startTag) || CONTENT_TAG.equals(startTag) || CONTENT_ENCODED_ALT_TAG.equals(startTag)) {
                    entry.setContent(parser.nextText());
                }

            } else if (eventType == XmlPullParser.END_TAG) {
                String endTag = parser.getName();
                if (ENTRY_TAG.equals(endTag)) {
                    feed.addEnty(entry);
                    break;
                }
            }
            eventType = parser.next();
        }
    }

    private void processAuthor(AtomEntry entry, XmlPullParser parser) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        String authorName = "";
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                String startTag = parser.getName();
                if (NAME_TAG.equals(startTag)) {
                    authorName = parser.nextText();
                }
            } else if (eventType == XmlPullParser.END_TAG) {
                String endTag = parser.getName();
                if (AUTHOR_TAG.equals(endTag)) {
                    entry.getAuthors().add(authorName);
                    break;
                }
            }
            eventType = parser.next();
        }
    }

    private void getAttributeMap(XmlPullParser parser) {
        attMap.clear();
        for (int i = 0; i < parser.getAttributeCount(); i++) {
            attMap.put(parser.getAttributeName(i), parser.getAttributeValue(i));
        }
    }

    public void setParseDates(boolean parseDates) {
        this.parseDates = parseDates;
    }

    public class AtomParserTimeOut implements Runnable {

        private InputStream in;
        private AtomFeed feed;

        public AtomParserTimeOut(InputStream in) {
            this.in = in;
        }

        public void run() {
            AtomParser parser = new AtomParser();
            try {
                feed = parser.parse(in);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public synchronized AtomFeed getFeed() {
            return feed;
        }
    }

    private String iso8601StringToUTCDateString(String isoDate) {
        if (isoDate != null) {
            isoDate = isoDate.trim();
            if (isoDate.endsWith("z") || isoDate.endsWith("Z")) {
                return isoDate = isoDate.substring(0, isoDate.length() - 1) + "+0000";
            }
        }
        return isoDate;
    }
}
