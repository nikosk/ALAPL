package gr.dsigned.atom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Entry {

    private String id;
    private String title;
    private String url;
    private Date updated;
    private Date published;
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

    @Override
    public String toString() {
        return "Entry [authors=" + authors + ", catogories=" + catogories
                + ", content=" + content + ", id=" + id + ", links=" + links
                + ", published=" + published + ", summary=" + summary
                + ", url=" + url
                + ", title=" + title + ", updated=" + updated + "]";
    }
}
