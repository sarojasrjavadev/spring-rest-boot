package com.newsfetch.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
	
	private Source source;
	private String author;
	private String title;
	private String description;
	private String publishedAt;
	private String urlToImg;
	private URL url;
	
	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getUrlToImg() {
		return urlToImg;
	}

	public void setUrlToImg(String urlToImg) {
		this.urlToImg = urlToImg; 
	}
	
	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
	
}
