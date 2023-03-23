package com.javacore.video62;

import java.util.Scanner;
import java.util.Stack;

public class TestStack {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	Stack<String> stackChuoi = new Stack<String>();
	Stack<String> stackChuoi2 = new Stack<String>();
	String s1 = "Chao ban";
	for (int i = 0; i < s1.length(); i++) {
		stackChuoi.push(s1.charAt(i)+"");
	}
	System.out.println(s1);
	System.out.println(stackChuoi.toString());
//	for (int i = 0; i < stackChuoi.size(); i++) {
//		System.out.println(stackChuoi.peek());
//	}
//	System.out.println(stackChuoi.toString());
	System.out.println(stackChuoi.size());
	for (int i = 0; i < s1.length(); i++) {
		System.out.print(stackChuoi.pop());
	}
	System.out.println();
	System.out.println(stackChuoi.toString());
	
//	chuyen tu he thap phan sang he nhi phan
	int number = 5;
	stackChuoi2=chuyenNhiPhan(number);
	System.out.println(stackChuoi2.toString());
}
public static Stack<String> chuyenNhiPhan(int number) {
	Stack<String> stach2 = new Stack<String>();
	while (number>0) {
		stach2.push(number%2+"");
		number=number/2;
		
	}
	return stach2;
}
}
