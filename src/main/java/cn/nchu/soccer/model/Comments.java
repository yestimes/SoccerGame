package cn.nchu.soccer.model;

public class Comments {
	private int id;
	private int audienceId;
	private int matchId;
	private String content;
	private String time;
	
	public Comments(){
		
	}
	public Comments(int id, int audienceId, int matchId, String content, String time){
		this.id = id;
		this.audienceId = audienceId;
		this.matchId = matchId;
		this.content = content;
		this.time = time;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAudienceId() {
		return audienceId;
	}
	public void setAudienceId(int audienceId) {
		this.audienceId = audienceId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
}
