package com.javacore.video61;

public class Student {
	private int studentCode;
	private String name;
	private int yearOfBirth;
	private double mediumScore;
	
	public Student(int studentCode, String name, int yearOfBirth, double mediumScore) {
		super();
		this.studentCode = studentCode;
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.mediumScore = mediumScore;
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

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public double getMediumScore() {
		return mediumScore;
	}

	public void setMediumScore(double mediumScore) {
		this.mediumScore = mediumScore;
	}
	
	
}
