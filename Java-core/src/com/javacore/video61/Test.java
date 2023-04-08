package com.javacore.video61;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
public static void main(String[] args) {
	Student std1 = new Student(1, "Danh", 1985, 9);
	Student std2 = new Student(2, "Trung", 1986, 5);
	Student std3 = new Student(3, "Chanh", 1989, 7);
	Student std4 = new Student(4, "Chinh", 19789, 7);
	
	ArrayList<Student> list = new ArrayList<Student>();
	list.add(std1);
	list.add(std2);
	list.add(std4);
	list.add(std3);
	System.out.println(list.toString());
	Collections.sort(list);
	System.out.println(list.toString());
	Collections.reverse(list);
	System.out.println(list.toString());
}
}
