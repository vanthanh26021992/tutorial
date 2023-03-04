package com.javacore.video31;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Nhap khoi luong cafe:");
	double a = sc.nextDouble();
	System.out.println("Nhap gia tien tren 1 kg:");
	double b = sc.nextDouble();
	System.out.println("Nhap ten loai cafe:");
	String c = sc.next();
	
	
	Bill bi = new Bill(c, a, b);
	System.out.println("Thanh tien: "+bi.total());
	System.out.println(bi.compare(11));
	System.out.println(bi.compare(8));
	System.out.println(bi.compare1());
	System.out.println("Số tiền được giảm giá là: "+bi.discount());
	System.out.println("Số tiền còn phải trả sau khi được giảm giá là: "+bi.theMoneyHaveToPay());
}
}
