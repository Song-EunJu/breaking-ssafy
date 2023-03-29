package com.ssafy.test.dto;

public class Mobile {
	private String mobileCode;
	private String model;
	private int price;
	private String company;
	public String getMobileCode() {
		return mobileCode;
	}
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Mobile(String mobileCode, String model, int price, String company) {
		super();
		this.mobileCode = mobileCode;
		this.model = model;
		this.price = price;
		this.company = company;
	}
}
