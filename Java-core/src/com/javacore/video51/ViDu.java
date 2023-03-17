package com.javacore.video51;

public class ViDu {
public static void main(String[] args) {
	String s1 = "Xin chào cô chú, xin chào các bạn, Xin chào!";
	String s2 = "Xin chào";
	String s3 = "Xin chào 123";
	char c1 = 'ô';
	
//	Hàm indexOf kiểm tra 1 chuỗi có trong 1 chuối khác không nếu có trả về vị trí nếu ko có trả về -1 
	System.out.println(s1.indexOf(s2));
	System.out.println(s1.indexOf(s3));
//	Nếu thêm vị trí vào thì sẽ tìm từ vị trí thứ 2 của s1
	System.out.println(s1.indexOf(s2,2));
	System.out.println(s1.indexOf(s2,0)); //Giống bên trên nếu vị trí từ 0
	
//	Tìm kiếm char
	System.out.println(s1.indexOf(c1,0));
	System.out.println(s1.indexOf(c1,20));
	
//	Hàm lastIndexOf giống indexOf nhưng tìm từ phải sang trái
	System.out.println(s1.lastIndexOf(s2));
}
}
