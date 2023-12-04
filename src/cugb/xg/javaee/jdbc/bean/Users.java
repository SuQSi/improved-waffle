package cugb.xg.javaee.jdbc.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Users {
	private int userid;
	private String username;
	private String password;
	private Timestamp createdate;
	
	public Users(){
		
	}
	
	public Users(String username, String password, Timestamp createdate) {
		super();
		this.username = username;
		this.password = password;
		this.createdate = createdate;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", password=" + password + ", createdate="
				+ createdate + "]";
	}
	
}
