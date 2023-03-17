package com.javacore.video50;

public class ViDu {
public static void main(String[] args) {
	String s1 = "titv.vn";
	String s2 = "TITV.vn";
	String s3 = "titv.vn";
	
	System.out.println(s1.equals(s2));
	System.out.println(s1.equals(s3));
	System.out.println(s1.equalsIgnoreCase(s2));
	System.out.println(s1.equalsIgnoreCase(s3));
//	hàm compareTo so sánh lớn hơn
	String sv1 = "Nguyễn Văn A";
	String sv2 = "Nguyễn Văn B";
	String sv3 = "Nguyễn Văn Cd";
	String sv4 = "Nguyễn Văn A";
	System.out.println(sv1.compareTo(sv2));
	System.out.println(sv1.compareTo(sv3));
	System.out.println(sv1.compareTo(sv4));
//	compareToIgnoreCase - so sánh ko phân biệt hoa thường
//	Hàm regionMatches - so sánh một đoạn
	String r1 = "TITV.vn";
	String r2 = "TV.v";
	boolean check = r1.regionMatches(2, r2, 0, 4);
	System.out.println(check);
	
//	Hàm startWith Hàm kiểm tra chuỗi bắt đầu bằng ...
	String sdt = "037456789";
	System.out.println(sdt.startsWith("037"));
	System.out.println(sdt.startsWith("034"));
	
//	Hàm startWith Hàm kiểm tra chuỗi kết thúc bằng ...
	String tenFile1 = "file 1.JPG";
	String tenFile2 = "file 1.PDF";
	if (tenFile1.endsWith(".JPG")) {
		System.out.println("File này là file hình ảnh");
	} else if (tenFile1.endsWith(".PDF")){
		System.out.println("File này là file PDF");
	}
	
	if (tenFile2.endsWith(".JPG")) {
		System.out.println("File này là file hình ảnh");
	} else if (tenFile2.endsWith(".PDF")){
		System.out.println("File này là file PDF");
	}
}
}
