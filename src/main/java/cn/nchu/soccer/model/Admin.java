package cn.nchu.soccer.model;

public class Admin {
	private int id;
	private String username;
	private String password;
	private String tel;
	
	public Admin(){
		
	}
	public Admin(int id, String username, String password, String tel){
		this.id = id;
		this.username = username;
		this.password = password;
		this.tel = tel;
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
}
