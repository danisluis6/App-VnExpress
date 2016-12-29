package com.example.enclaveit.version1.model.bean;

/**
 * A representation of an rss item from the list.
 * 
 * @author Veaceslav Grec
 * 
 */
public class RssItem {

	private final String title;
	private final String description;
	private final String date;
	private final String link;

	public RssItem(String title, String description, String date, String link) {
		this.title = title;
		this.description = description;
		this.date = date;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public String getLink() {
		return link;
	}
}
