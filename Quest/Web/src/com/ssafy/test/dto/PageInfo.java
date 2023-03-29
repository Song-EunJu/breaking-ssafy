package com.ssafy.test.dto;

public class PageInfo {
	private boolean isForward;
	private String url;
	
	public boolean isForward() {
		return isForward;
	}
	
	public void setForward(boolean isForward) {
		this.isForward = isForward;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public PageInfo(boolean isForward, String url) {
		super();
		this.isForward = isForward;
		this.url = url;
	}
	
	public PageInfo(String url) {
		this.isForward = true;
		this.url = url;
	}
}
