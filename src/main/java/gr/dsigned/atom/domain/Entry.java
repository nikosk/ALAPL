/*
 * Copyright (C) 2010 Mathieu Favez - http://mfavez.com
 *
 *
 * This file is part of FeedGoal.
 * 
 * FeedGoal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FeedGoal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with FeedGoal.  If not, see <http://www.gnu.org/licenses/>.
 */
package gr.dsigned.atom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//<entry> 
//<title>Παναθηναϊκό μεγαλείο</title> 
//<link rel="alternate" href="http://prasinanea.gr/football/article104938.ece" /> 
//<link rel="enclosure" type="image/jpeg" href="http://prasinanea.gr/incoming/article104874.ece/BINARY/w300/670245.jpg" title="" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104926.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104935.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104923.ece" title="Η φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104925.ece" title="Η φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104927.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104920.ece" title="Οι Αμαζόνες του Τριφυλλιού πανηγυρίζουν με τους οργανωμένους φιλάθλους." /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104932.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104929.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104937.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<category term="football" label="Ποδόσφαιρο" /> 
//<category term="ece_frontpage" label="Αρχική" /> 
//<category term="@topStories" /> 
//<author> 
//<name>Μπάμπης Τσιμπίδας</name> 
//</author> 
//<id>http://prasinanea.gr/104938</id> 
//<updated>2010-05-02T21:15:12Z</updated> 
//<published>2010-05-02T21:12:19Z</published> 
//<summary>Με μία φιέστα μοναδική για τα ελληνικά δεδομένα σφραγίστηκε η επίτευξη του νταμπλ για τη σεζόν 2009-2010 από την ποδοσφαιρική ομάδα του Τριφυλλιού.</summary> 
//<content:encoded><![CDATA[><p>Απολαύστε εικόνες από την φιέστα των πρασίνων μέσα από την κάμερα των "Πράσινων Νέων":<br /><a href="http://prasinanea.gr/football/article104920.ece" id="_0b9077cc-7acc-4017-ae21-d9703f665ff1">Οι Αμαζόνες του Τριφυλλιού πανηγυρίζουν με τους οργανωμένους φιλάθλους.</a> <br /><a href="http://prasinanea.gr/football/article104923.ece" id="_37f93e24-b3ff-4272-b8e9-f35ad176b492"><a href="http://prasinanea.gr/football/article104935.ece" id="_f1db5627-8532-48a1-bc63-e9efa7756351">Η Φιέστα του Παναθηναϊκού</a><br /><a href="http://prasinanea.gr/football/article104937.ece" id="_3e322126-069c-4cc9-a476-e1a812d994de">Η Φιέστα του Παναθηναϊκού</a><br /><a href="http://prasinanea.gr/football/article104929.ece" id="_3b03bd75-7bd2-4b14-85ee-8f683000a1df"><a href="http://prasinanea.gr/football/article104932.ece" id="_380c7406-c783-4823-88d3-6180d89d7c82">Η Φιέστα του Παναθηναϊκού</a></a></a><br /><a href="http://prasinanea.gr/football/article104926.ece" id="_7657928c-5499-47e7-9bf7-7fbcbf0195eb">Η Φιέστα του Παναθηναϊκού<br /><a href="http://prasinanea.gr/football/article104927.ece" id="_33a1c88b-0570-4e6e-bf3f-8a9f6b07c837">Η Φιέστα του Παναθηναϊκού</a></a><br /><a href="http://prasinanea.gr/football/article104925.ece" id="_1b2164d2-6909-4c88-ae12-ef0be58d693e">Η φιέστα του Παναθηναϊκού</a> <br /> </p>]]></content:encoded> 
//</entry> 
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
