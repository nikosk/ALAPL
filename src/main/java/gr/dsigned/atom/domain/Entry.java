package gr.dsigned.atom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entry {

    private String id;
    private String title;
    private String url;
    private Date updated;
    private String updatedString;
    private Date published;
    private String publishedString;
    private String summary;
    private String content;
    private List<String> authors = new ArrayList<String>();
    private List<Category> catogories = new ArrayList<Category>();
    private List<Link> links = new ArrayList<Link>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<Category> getCatogories() {
        return catogories;
    }

    public void setCatogories(List<Category> catogories) {
        this.catogories = catogories;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(Link link) {
        this.links.add(link);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedString() {
        return publishedString;
    }

    public void setPublishedString(String publishedString) {
        this.publishedString = publishedString;
    }

    public String getUpdatedString() {
        return updatedString;
    }

    public void setUpdatedString(String updatedString) {
        this.updatedString = updatedString;
    }

    

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nid: ");
        toStringBuilder.append(id);
        toStringBuilder.append("\ntitle: ");
        toStringBuilder.append(title);
        toStringBuilder.append("\nurl: ");
        toStringBuilder.append(url);
        toStringBuilder.append("\nupdated: ");
        toStringBuilder.append(updated);
        toStringBuilder.append("\nupdatedString: ");
        toStringBuilder.append(updatedString);
        toStringBuilder.append("\npublished: ");
        toStringBuilder.append(published);
        toStringBuilder.append("\npublishedString: ");
        toStringBuilder.append(publishedString);
        toStringBuilder.append("\nsummary: ");
        toStringBuilder.append(summary);
        toStringBuilder.append("\ncontent: ");
        toStringBuilder.append(content);
        toStringBuilder.append("\nauthors: ");
        if (authors != null) {
            toStringBuilder.append("\nSize: ");
            toStringBuilder.append(authors.size());
            java.util.Iterator<String> collectionIiterator = authors.iterator();
            for (int i = 0; collectionIiterator.hasNext(); ++i) {
                toStringBuilder.append("\nIndex ");
                toStringBuilder.append(i);
                toStringBuilder.append(": ");
                toStringBuilder.append(collectionIiterator.next());
            }
        } else {
            toStringBuilder.append("NULL");
        }
        toStringBuilder.append("\ncatogories: ");
        if (catogories != null) {
            toStringBuilder.append("\nSize: ");
            toStringBuilder.append(catogories.size());
            java.util.Iterator<Category> collectionIiterator = catogories.iterator();
            for (int i = 0; collectionIiterator.hasNext(); ++i) {
                toStringBuilder.append("\nIndex ");
                toStringBuilder.append(i);
                toStringBuilder.append(": ");
                toStringBuilder.append(collectionIiterator.next());
            }
        } else {
            toStringBuilder.append("NULL");
        }
        toStringBuilder.append("\nlinks: ");
        if (links != null) {
            toStringBuilder.append("\nSize: ");
            toStringBuilder.append(links.size());
            java.util.Iterator<Link> collectionIiterator = links.iterator();
            for (int i = 0; collectionIiterator.hasNext(); ++i) {
                toStringBuilder.append("\nIndex ");
                toStringBuilder.append(i);
                toStringBuilder.append(": ");
                toStringBuilder.append(collectionIiterator.next());
            }
        } else {
            toStringBuilder.append("NULL");
        }
        return toStringBuilder.toString();
    }
}
