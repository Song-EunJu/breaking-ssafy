package com.ssafy.test.dto;

public class UserInfo {
	private String id;
	private String pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public UserInfo(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	
}
