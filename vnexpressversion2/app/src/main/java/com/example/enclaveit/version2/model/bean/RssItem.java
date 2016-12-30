package com.example.enclaveit.version2.model.bean;

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
	private final String urlPicture;
	private final String urlAddress;

	public RssItem(String title, String description, String date, String link, String urlPicture, String urlAddress) {
		this.title = title;
		this.description = description;
		this.date = date;
		this.link = link;
		this.urlPicture = urlPicture;
		this.urlAddress = urlAddress;
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

	public String getUrlPicture() {
		return urlPicture;
	}

	public String getUrlAddress() {
		return urlAddress;
	}
}
