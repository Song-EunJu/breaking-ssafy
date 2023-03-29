package com.ssafy.education.subject;

public class Algo extends Subject {
	
	public String level; //알고리즘 레벨
	
	public Algo(){}
	
	public Algo(String name, int time, String level) {
		super(name, time);
		setLevel(level);
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getLevel());
		return sb.toString();
	}

}
