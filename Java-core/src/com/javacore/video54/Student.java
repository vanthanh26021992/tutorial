package com.javacore.video54;

public class Student implements Comparable<Student>{
	private int studentCode;
	private String name;
	private String classs;
	private double diem;
	
	public Student(int studentCode, String name, String classs, double diem) {
		super();
		this.studentCode = studentCode;
		this.name = name;
		this.classs = classs;
		this.diem = diem;
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

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public int compareTo(Student o) {
//		return this.studentCode-o.studentCode;
		
		String tenThis = this.getTen();
		String tenO = o.getTen();
		return tenThis.compareTo(tenO);
	}
	
	public double compareTo1(Student o) {
		return this.diem-o.diem;
		
	}
	
	public String getTen() {
		String s=this.name.trim();
		if (s.indexOf(" ")>=0) {
			int vt = s.lastIndexOf(" ");
			return s.substring(vt+1);
		}else {
			return s;
		}
	}
	
}
