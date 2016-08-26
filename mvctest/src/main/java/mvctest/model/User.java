package mvctest.model;

public class User {
	private int userid;
	private String username;
	private String userpass;

	public User() {

	}

	public User(int userid, String username, String userpass) {
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;

	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	// 默认实现toString()方法

	public String toString() {
		return username + "," + userpass;
	}
}
