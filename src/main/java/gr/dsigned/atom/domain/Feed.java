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

public class Feed {
	private String id;
	private String mURL;
	private String mTitle;
	private String subtitle;
	private String icon;
	private Date updated;
	
	private List<Entry> entries;

	public Feed() {
		this.entries = new ArrayList<Entry>();
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

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public void addEnty(Entry entry) {
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

}
