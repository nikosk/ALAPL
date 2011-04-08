package gr.dsigned.atom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtomFeed {

    private String id;
    private String mURL;
    private String mTitle;
    private String subtitle;
    private String icon;
    private Date updated;
    private String updatedString;
    private List<AtomEntry> entries;

    public AtomFeed() {
        this.entries = new ArrayList<AtomEntry>();
    }

    public String getmURL() {
        return mURL;
    }

    public void setmURL(String mURL) {
        this.mURL = mURL;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public List<AtomEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<AtomEntry> entries) {
        this.entries = entries;
    }

    public void addEnty(AtomEntry entry) {
        this.entries.add(entry);
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getUpdatedString() {
        return updatedString;
    }

    public void setUpdatedString(String updatedString) {
        this.updatedString = updatedString;
    }
}