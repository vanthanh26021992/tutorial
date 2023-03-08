package com.javacore.video37;

import java.util.Objects;

public class Student {
	private int studentCode;
	private String firstAndLastName;
	private BirthOfDate dateOfBirth;
	private double mediumScore;
	private Class classs;
	
	public Student(int studentCode, String firstAndLastName, BirthOfDate dateOfBirth, double mediumScore,
			Class classs) {
		super();
		this.studentCode = studentCode;
		this.firstAndLastName = firstAndLastName;
		this.dateOfBirth = dateOfBirth;
		this.mediumScore = mediumScore;
		this.classs = classs;
	}

	public int getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}

	public String getFirstAndLastName() {
		return firstAndLastName;
	}

	public void setFirstAndLastName(String firstAndLastName) {
		this.firstAndLastName = firstAndLastName;
	}

	public BirthOfDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(BirthOfDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getMediumScore() {
		return mediumScore;
	}

	public void setMediumScore(double mediumScore) {
		this.mediumScore = mediumScore;
	}

	public Class getClasss() {
		return classs;
	}

	public void setClasss(Class classs) {
		this.classs = classs;
	}

	public String facultyName() {
		return this.classs.getFacultyName();
	}
	
	public boolean passOrFail() {
		return this.mediumScore>=5;
	}
	
	public boolean checkDateOfBirth(Student std) {
		return this.dateOfBirth.getDay()==std.dateOfBirth.getDay();
	}



	
	public boolean checkDateOfBirth1(Student std) {
		return this.dateOfBirth.equals(std.dateOfBirth);
	}
}
