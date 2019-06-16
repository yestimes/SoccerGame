package cn.nchu.soccer.model;

public class Team {
	private int id;
	private String name;
	private int matchTimes;
	private int winTimes;
	private int tieTimes; 
	private int score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMatchTimes() {
		return matchTimes;
	}
	public void setMatchTimes(int matchTimes) {
		this.matchTimes = matchTimes;
	}
	public int getWinTimes() {
		return winTimes;
	}
	public void setWinTimes(int winTimes) {
		this.winTimes = winTimes;
	}
	public int getTieTimes() {
		return tieTimes;
	}
	public void setTieTimes(int tieTimes) {
		this.tieTimes = tieTimes;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	

}
