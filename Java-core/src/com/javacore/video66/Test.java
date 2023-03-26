package com.javacore.video66;

public class Test {
	public static void main(String[] args) {
		Student  std = new Student<Integer>(15);
		System.out.println(std.getValue());
		Student std1 = new Student<String>("Muoi lam");
		System.out.println(std1.getValue());
	}
}
