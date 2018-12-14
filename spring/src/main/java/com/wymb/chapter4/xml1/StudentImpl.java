package com.wymb.chapter4.xml1;

public class StudentImpl implements Student{

	private int studentNo;
	private String studentName;

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void showDetails() {
		System.out.println(this.studentNo+"："+this.studentName);
	}
}
