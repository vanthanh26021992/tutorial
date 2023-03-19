package com.javacore.video54;

public class Test {
public static void main(String[] args) {
	Student st1 = new Student(150, "Trần văn Thanh", "Lop 1", 9);
	Student st2 = new Student(100, "Nguyễn Thị Thanh Hoa", "Lop 2", 8);
	Student st3 = new Student(199, "Nguyễn Văn An", "Lop 3", 6);
	 System.out.println(st1.compareTo(st2));
	 System.out.println(st1.compareTo(st3));
	 System.out.println(st3.compareTo(st1));
	 
	 System.out.println("------------------");
	 System.out.println(st1.compareTo1(st2));
	 System.out.println(st1.compareTo1(st3));
	 System.out.println(st3.compareTo1(st2));
}
}
