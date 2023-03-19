package com.javacore.video55;

import java.util.Comparator;

public class Student implements Comparable<Student>{
	private int studentCode;
	private String name;
	private double testScore;
	
	public Student(int studentCode, String name, double testScore) {
		this.studentCode = studentCode;
		this.name = name;
		this.testScore = testScore;
	}

	public int getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTestScore() {
		return testScore;
	}

	public void setTestScore(double testScore) {
		this.testScore = testScore;
	}

	@Override
	public int compareTo(Student o) {
		String tenThis = this.getTen();
		String tenO = o.getTen();
		return tenThis.compareTo(tenO);
	}

	public String getTen() {
		String s = this.name.trim();
		if (s.indexOf(" ")>=0) {
			int vt = s.lastIndexOf(" ");
			return s.substring(vt+1);
		} else {
			return s;
		}
		
	}

	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + ", testScore=" + testScore + "]";
	}
	
	
}
