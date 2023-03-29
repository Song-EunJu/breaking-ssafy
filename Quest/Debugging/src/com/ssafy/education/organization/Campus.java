package com.ssafy.education.organization;

public class Campus extends Organization{
	private String campusId; //캠퍼스ID
	private int roomTotalCount;//강의실 수
	private int roomEmptyCount;//빈강의실 수

	public Campus() {}
	
	public Campus(String name, int studentCount, String campusId, int roomTotalCount, int roomEmptyCount) {
		super(name, studentCount);
		setCampusId(campusId);
		setRoomTotalCount(roomTotalCount);
		setRoomEmptyCount(roomEmptyCount);
	}
	
	public String getCampusId() {
		return campusId;
	}
	public void setCampusId(String campusId) {
		this.campusId = campusId;
	}
	public int getRoomTotalCount() {
		return roomTotalCount;
	}
	public void setRoomTotalCount(int roomTotalCount) {
		this.roomTotalCount = roomTotalCount;
	}
	public int getRoomEmptyCount() {
		return roomEmptyCount;
	}
	public void setRoomEmptyCount(int roomEmptyCount) {
		this.roomEmptyCount = roomEmptyCount;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getCampusId()).append("\t")
		  .append(getRoomTotalCount()).append("\t")
		  .append(getRoomEmptyCount());
		return sb.toString();
	}
}
