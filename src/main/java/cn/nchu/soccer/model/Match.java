package cn.nchu.soccer.model;

public class Match {
	private int id;
	private int team1;
	private int team2;
	private int in1;
	private int in2;
	private String startTime;
	private int spendTime;
	private int state;
	
	public Match(){
		
	}
	public Match(int id, int team1, int team2, int in1, int in2, String startTime, int spendTime, int state){
		this.id = id;
		this.team1 = team1;
		this.team2 = team2;
		this.in1 = in1;
		this.in2 = in2;
		this.startTime = startTime;
		this.spendTime = spendTime;
		this.state = state;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIn1() {
		return in1;
	}
	public void setIn1(int in1) {
		this.in1 = in1;
	}
	public int getIn2() {
		return in2;
	}
	public void setIn2(int in2) {
		this.in2 = in2;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getSpendTime() {
		return spendTime;
	}
	public void setSpendTime(int spendTime) {
		this.spendTime = spendTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getTeam1() {
		return team1;
	}
	public void setTeam1(int team1) {
		this.team1 = team1;
	}
	public int getTeam2() {
		return team2;
	}
	public void setTeam2(int team2) {
		this.team2 = team2;
	}


}
