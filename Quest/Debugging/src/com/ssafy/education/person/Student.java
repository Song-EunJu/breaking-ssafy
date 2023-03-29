package com.ssafy.education.person;

public class Student extends Person{
	private String classesname; //수강 과목
	private String studentId;// 학생번호
	private boolean isGraduate;//졸업여부
	
	public Student() {}
	public Student(String name, int age, String phone, String classesName, String studentId, boolean isGraduate) {
		super(name, age, phone);
		setClassesname(classesName);
		setStudentId(studentId);
		setGraduate(isGraduate);
	}
	
	
	public String getClassesname() {
		return classesname;
	}
	public void setClassesname(String classesname) {
		this.classesname = classesname;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public boolean isGraduate() {
		return isGraduate;
	}
	public void setGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getClassesname()).append("\t")
		  .append(getStudentId()).append("\t")
		  .append(isGraduate());
		return sb.toString();
	}
}