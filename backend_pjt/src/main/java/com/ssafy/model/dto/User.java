package com.ssafy.model.dto;

public class User {
	private String name;
	private String userId;
	private String password;
	private String email;
	private String city;
	private String region;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public User(String name, String userId, String password, String email, String city, String region) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.city = city;
		this.region = region;
	}
	
	
}
