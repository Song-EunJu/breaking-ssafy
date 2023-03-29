package com.ssafy.model.dto;


public class MapInfo {
	int sido_code;
	int gugun_code;
	int content_type_id;
	String title;
	String addr1;
	String first_image;
	double latitude;
	double longitude;
	public MapInfo(int sido_code, int gugun_code, int content_type_id,
			String title, String addr1, String first_image, double latitude, double longitude) {
		super();
		this.sido_code = sido_code;
		this.gugun_code = gugun_code;
		this.content_type_id = content_type_id;
		this.title = title;
		this.addr1 = addr1;
		this.first_image = first_image;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getSido_code() {
		return sido_code;
	}
	public void setSido_code(int sido_code) {
		this.sido_code = sido_code;
	}
	public int getGugun_code() {
		return gugun_code;
	}
	public void setGugun_code(int gugun_code) {
		this.gugun_code = gugun_code;
	}
	public int getContent_type_id() {
		return content_type_id;
	}
	public void setContent_type_id(int content_type_id) {
		this.content_type_id = content_type_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getFirst_image() {
		return first_image;
	}
	public void setFirst_image(String first_image) {
		this.first_image = first_image;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
