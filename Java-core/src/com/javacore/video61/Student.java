package com.javacore.video61;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student>, Comparator<Student>{
	private int studentCode;
	private String name;
	private int yearOfBirth;
	private double mediumScore;
	
	public Student(int studentCode, String name, int yearOfBirth, double mediumScore) {
		this.studentCode = studentCode;
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.mediumScore = mediumScore;
	}



	public Student(int studentCode) {
		this.studentCode = studentCode;
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

	@Override
	public int compareTo(Student o) {
		return (int) this.mediumScore- (int) o.mediumScore;
	}





	@Override
	public int hashCode() {
		return Objects.hash(mediumScore, name, studentCode, yearOfBirth);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return studentCode == other.studentCode;
	}



	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + ", yearOfBirth=" + yearOfBirth
				+ ", mediumScore=" + mediumScore + "]\r";
	}
	
	
}
