package com.javacore.video52;

public class ViDu {
public static void main(String[] args) {
	String s1 = "tItv";
	String s2 = ".Vn";
	
	String s3 = s1+s2;
//	Hàm cocat - nối chuỗi
	String s4 = s1.concat(s2);
	System.out.println(s3.equals(s4));
//	Hàm replace = thay đổi
	String s5 = "Tung.vn";
	String s6=s5.replaceAll("Tung", "TITV");
//	Lưu ý s5 không thay đổi chỉ trả về một giá trị mà ta phải gắn vào một biến khác 
	System.out.println(s5);
	System.out.println(s6);
//	toLowerCase - viết thường hết
	String s7=s3.toLowerCase();
	System.out.println(s7);
//	toUpperCase - viết hoa hết
	String s8 =s3.toUpperCase();
	System.out.println(s8);
//	trim() - xóa bỏ khoảng trắng dư thừa ở đầu chuỗi
	String s9 = "    ao ";
	System.out.println(s9.trim());
//	subString - cắt chuỗi con
	String s10 = "Xin chào các bạn, mình là TITV.vn";
	String s11 = s10.substring(10);
	System.out.println(s11);
	String s12 = s10.substring(10,15);
	System.out.println(s12);
	String s13 = s10.substring(0,32);
	System.out.println(s13);
}
}
