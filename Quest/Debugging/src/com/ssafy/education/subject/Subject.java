package com.ssafy.education.subject;

public class Subject {
	private String name; //과목명
	private int time; //수업시수

	public Subject() {}
	public Subject(String name, int time) {
		setName(name);
		setTime(time);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(getName()).append("\t")
		  .append(getTime());
		return sb.toString();
	}
}
