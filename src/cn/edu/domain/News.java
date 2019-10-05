package cn.edu.domain;

public class News {
	private String news_id ; 
	private String news_classify ; 
	private String news_topic ; 
	private String news_content ; 
	private String release_time ; 
	private String picture;
	

	public String getNews_id() {
		return news_id;
	}
	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}
	public String getNews_classify() {
		return news_classify;
	}
	public void setNews_classify(String news_classify) {
		this.news_classify = news_classify;
	}
	public String getNews_topic() {
		return news_topic;
	}
	public void setNews_topic(String news_topic) {
		this.news_topic = news_topic;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public String getRelease_time() {
		return release_time;
	}
	public void setRelease_time(String release_time) {
		this.release_time = release_time;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
}
