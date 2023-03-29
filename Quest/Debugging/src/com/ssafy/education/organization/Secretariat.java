package com.ssafy.education.organization;

public class Secretariat extends Organization{
	private String region;//담당지역
	
	public Secretariat() {}
	public Secretariat(String name, int studentCount, String region) {
		super(name, studentCount);
		setRegion(region);
	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getRegion());
		return sb.toString();
	}
}