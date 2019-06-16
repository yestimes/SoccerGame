package cn.nchu.soccer.model;

public class News {
	private String content;
	private String url;
	private String date;
	
	public News(){
		
	}
	public News(String content, String url, String date){
		this.content = content;
		this.url = url;
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
