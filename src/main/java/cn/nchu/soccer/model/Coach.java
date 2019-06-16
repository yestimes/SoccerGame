package cn.nchu.soccer.model;

public class Coach {
	private int id;
	private String username;
	private String password;
	private String realname;
	private int teamId;
	private String tel;
	
	public Coach(){
		
	}
	public Coach(int id, String username, String password, String realname, int teamId, String tel){
		this.id = id;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.realname = realname;
		this.teamId = teamId;
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
}
