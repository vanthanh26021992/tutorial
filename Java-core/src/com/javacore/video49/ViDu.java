package com.javacore.video49;

import java.util.Scanner;

public class ViDu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.println("Nhập vào chuỗi: ");
		s=sc.nextLine();
		System.out.println(s.length());
		for (int i = 0; i < s.length(); i++) {
			System.out.println("Phần tử thứ "+i+" là: "+s.charAt(i));
		}
		System.out.println();
		char[]   arrayChar = new char[20];
		s.getChars(2, 5, arrayChar, 0);
		for (int i = 0; i < arrayChar.length; i++) {
			System.out.println("Giá trị của mảng tại "+i+" là: "+arrayChar[i]);
		}
		
		System.out.println();
		byte[] arrayBytes = s.getBytes();
		for (byte b : arrayBytes) {
			System.out.println(b);
		}
	}
}
