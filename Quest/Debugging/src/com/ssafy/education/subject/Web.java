package com.ssafy.education.subject;

public class Web extends Subject {
	
	public int count; //수강 인원
	
	public Web() {}

	public Web(String name, int time, int count) {
		setName(name);
		setTime(time);
		setCount(count);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getCount());
		return sb.toString();
	}
	
	
	

}
