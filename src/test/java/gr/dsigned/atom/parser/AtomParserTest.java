package gr.dsigned.atom.parser;

import gr.dsigned.atom.domain.AtomFeed;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.junit.Assert.*;

public class AtomParserTest {

    @Test
    public void testParseOnline() throws XmlPullParserException, IOException {
        AtomParser parser = new AtomParser();
        parser.setParseDates(false);
        URL url = new URL("http://feeds.huffingtonpost.com/huffingtonpost/raw_feed");
        AtomFeed feed = parser.parse(url.openConnection().getInputStream());
        assertNotNull(feed);
        assertNotNull(feed.getLinks());
        assertNotNull(feed.getAlternateURL());
        assertTrue(feed.getEntries().size() > 0);
        assertTrue(feed.getEntries().get(0).getPublished() == null);
        assertTrue(feed.getEntries().get(0).getPublishedString() != null);
        assertTrue(feed.getEntries().get(0).getUpdated() == null);
        assertTrue(feed.getEntries().get(0).getUpdatedString() != null);
    }

    @Test
    public void testParseOnlineSport24() throws XmlPullParserException, IOException {
        AtomParser parser = new AtomParser();
        parser.setParseDates(false);
        URL url = new URL("http://sport24.gr/?widget=rssfeed&view=feed&contentId=174866");
        AtomFeed feed = parser.parse(url.openConnection().getInputStream());
        assertNotNull(feed);
        assertNotNull(feed.getLinks());
        assertNotNull(feed.getAlternateURL());
        assertTrue(feed.getEntries().size() > 0);
        assertTrue(feed.getEntries().get(0).getPublished() == null);
        assertTrue(feed.getEntries().get(0).getPublishedString() != null);
        assertTrue(feed.getEntries().get(0).getUpdated() == null);
        assertTrue(feed.getEntries().get(0).getUpdatedString() != null);
    }

    @Test
    public void testParseFile() throws XmlPullParserException, IOException {
        AtomParser parser = new AtomParser();
        parser.setParseDates(false);
        InputStream in = this.getClass().getResource("AtomTestFeed.xml").openStream();
        AtomFeed feed = parser.parse(in);
        assertNotNull(feed);
        assertNotNull(feed.getLinks());
        assertEquals(feed.getLinks().size(), 2);
        assertNotNull(feed.getAlternateURL());
        assertNotNull(feed.getEntries());
        assertTrue(feed.getEntries().size() > 0);
        assertTrue(feed.getEntries().get(0).getCatogories().size() > 0);
        assertTrue(feed.getEntries().get(0).getLinks().size() > 0);
        assertEquals(feed.getEntries().get(0).getAuthors().get(0), "Γιώργος Περπερ");
    }

    @Test
    public void testParseDatesTrue() throws XmlPullParserException, IOException {
        AtomParser parser = new AtomParser();
        parser.setParseDates(true);
        URL url = new URL("http://feeds.huffingtonpost.com/huffingtonpost/raw_feed");
        AtomFeed feed = parser.parse(url.openConnection().getInputStream());
        assertNotNull(feed);
        assertNotNull(feed.getLinks());
        assertNotNull(feed.getAlternateURL());
        assertTrue(feed.getEntries().size() > 0);
        assertTrue(feed.getEntries().get(0).getPublished() != null);
        assertTrue(feed.getEntries().get(0).getPublishedString() != null);
        assertTrue(feed.getEntries().get(0).getUpdated() != null);
        assertTrue(feed.getEntries().get(0).getUpdatedString() != null);
    }

    @Test
    public void testParseFileParseDatesTrue() throws XmlPullParserException, IOException {
        AtomParser parser = new AtomParser();
        parser.setParseDates(true);
        InputStream in = this.getClass().getResource("AtomTestFeed.xml").openStream();
        AtomFeed feed = parser.parse(in);
        assertNotNull(feed);
        assertEquals(feed.getLinks().size(), 2);
        assertNotNull(feed.getLinks());
        assertNotNull(feed.getAlternateURL());
        assertNotNull(feed.getEntries());
        assertTrue(feed.getEntries().size() > 0);
        assertTrue(feed.getEntries().get(0).getCatogories().size() > 0);
        assertTrue(feed.getEntries().get(0).getLinks().size() > 0);
    }

    @Test
    public void testTimeout() throws XmlPullParserException, IOException {
        AtomParser parser = new AtomParser();
        InputStream in = this.getClass().getResource("AtomTestFeed.xml").openStream();
        AtomFeed feed = parser.parse(in, 5000);
        assertNotNull(feed);
        assertEquals(feed.getLinks().size(), 2);
        assertNotNull(feed.getLinks());
        assertNotNull(feed.getAlternateURL());
        assertNotNull(feed.getEntries());
        assertTrue(feed.getEntries().size() > 0);
        assertTrue(feed.getEntries().get(0).getCatogories().size() > 0);
        assertTrue(feed.getEntries().get(0).getLinks().size() > 0);
        in = new URL("http://feeds.huffingtonpost.com/huffingtonpost/raw_feed").openStream();
        feed = parser.parse(in, 1000);
        assertNotNull(feed.getEntries()); // this test might fail, timeout is too low and it needs a working connection
    }

    @Test(expected = RuntimeException.class)
    public void testTimeoutException() throws XmlPullParserException, IOException {
        AtomParser parser = new AtomParser();
        InputStream in = new DelayingInputStream();
        assertNull(parser.parse(in, 100));
    }

    private class DelayingInputStream extends InputStream {

        @Override
        public int read() throws IOException {
            while (true) {
                // loop
            }
        }
    }
}
