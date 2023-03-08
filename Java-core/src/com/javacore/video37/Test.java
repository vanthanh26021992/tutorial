package com.javacore.video37;

public class Test {
public static void main(String[] args) {
	Class cl1 = new Class("A1", "Van");
	Class cl2 = new Class("A2", "toan");
	Class cl3 = new Class("A1", "toan");
	BirthOfDate dob1 = new BirthOfDate(01, 11, 2000);
	BirthOfDate dob2 = new BirthOfDate(02, 12, 2002);
	BirthOfDate dob3 = new BirthOfDate(01, 3, 2001);
	BirthOfDate dob4 = new BirthOfDate(01, 11, 2000);
	
	Student std1 = new Student(1, "Nguyen Van a", dob1, 7, cl1);
	Student std2 = new Student(2, "Nguyen Van b", dob2, 4, cl2);
	Student std3 = new Student(3, "Nguyen Van c", dob3, 6, cl3);
	Student std4 = new Student(3, "Nguyen Van d", dob4, 6, cl3);
	
	System.out.println("Ten khoa: "+std1.facultyName());
	System.out.println("Ten khoa: "+std2.facultyName());
	
	System.out.println("Ket qua cua hoc sinh 1: "+std1.passOrFail());
	System.out.println("Ket qua cua hoc sinh 2: "+std2.passOrFail());
	System.out.println("Ket qua cua hoc sinh 3: "+std3.passOrFail());
	
	System.out.println("Ngay sinh cua hoc sinh 1 co bang ngay sinh cua hoc sinh 2 khong: "+std1.checkDateOfBirth(std2));
	System.out.println("Ngay sinh cua hoc sinh 1 co bang ngay sinh cua hoc sinh 3 khong: "+std1.checkDateOfBirth(std3));
	System.out.println("Ngay sinh cua hoc sinh 1 co bang ngay sinh cua hoc sinh 2 khong: "+std1.checkDateOfBirth1(std2));
	System.out.println("Ngay sinh cua hoc sinh 1 co bang ngay sinh cua hoc sinh 3 khong: "+std1.checkDateOfBirth1(std3));
	System.out.println("Ngay sinh cua hoc sinh 1 co bang ngay sinh cua hoc sinh 4 khong: "+std1.checkDateOfBirth1(std4));
}
}
