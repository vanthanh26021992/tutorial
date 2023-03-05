package com.javacore.video34;

public class Test {
public static void main(String[] args) {
	MyDate md1 = new MyDate(15, 5, 2022);
	MyDate md2 = new MyDate(15, 5, 2022);
	MyDate md3 = new MyDate(18, 5, 2021);
	
	System.out.println("md1 voi md2: "+md1.equals(md2));
	System.out.println("md1 voi md2: "+md1.equals(md3));
	
	System.out.println("Hashcode md1: "+md1.hashCode());
	System.out.println("Hashcode md2: "+md2.hashCode());
	System.out.println("Hashcode md3: "+md3.hashCode());
}
}
