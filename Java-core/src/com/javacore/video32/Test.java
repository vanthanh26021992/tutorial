package com.javacore.video32;

public class Test {
public static void main(String[] args) {
	MyDate md = new MyDate(31, 2, 2023);
	System.out.println(md.getDay());
	md.setDay(35);
	System.out.println(md.getDay());
	md.setDay(30);
	System.out.println(md.getDay());
}
}
