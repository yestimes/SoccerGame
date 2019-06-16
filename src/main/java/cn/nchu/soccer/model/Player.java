package cn.nchu.soccer.model;

public class Player {
	private int id;
	private String username;
	private String password;
	private String realname;
	private int teamId;
	private String tel;
	private String position;
	private int goal;
	private int secAttack;
	
	public Player(){
		
	}
	public Player(int id, String username, String password, String realname, int teamId, String tel, double point, String position, int goal, int secAttack){
		this.id = id;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.realname = realname;
		this.teamId = teamId;
		this.position = position;
		this.goal = goal;
		this.secAttack = secAttack;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public int getSecAttack() {
		return secAttack;
	}
	public void setSecAttack(int secAttack) {
		this.secAttack = secAttack;
	}
}
