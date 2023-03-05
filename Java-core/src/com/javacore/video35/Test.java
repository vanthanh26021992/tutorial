package com.javacore.video35;

public class Test {
public static void main(String[] args) {
	MyDate md1 = new MyDate(5, 3, 2023);
	Author aut1 = new Author("Gosho Aoyama", md1);
	Book bk1 = new Book("CONAN", 100000, 1990, aut1);
	
	MyDate md2 = new MyDate(5, 3, 2023);
	Author aut2 = new Author("Gosho Aoyama2", md2);
	Book bk2 = new Book("CONAN2", 110000, 1990, aut2);
	
	MyDate md3 = new MyDate(5, 3, 2023);
	Author aut3 = new Author("Gosho Aoyama3", md3);
	Book bk3 = new Book("CONAN3", 120000, 1991, aut3);
	
	System.out.println(bk1);
	System.out.println(bk2);
	System.out.println(bk3);
	System.out.println("Sach 1 va sach 2 co cung nam khong: "+bk1.soSanhNamXuatBan(bk2));
	System.out.println("Sach 1 va sach 2 co cung nam khong: "+bk1.soSanhNamXuatBan(bk3));
	System.out.println("Gia sach 1 sau giam gia: "+bk1.giaSachSauGiamGia(10));
	System.out.println("Gia sach 2 sau giam gia: "+bk2.giaSachSauGiamGia(10));
	System.out.println("Gia sach 3 sau giam gia: "+bk3.giaSachSauGiamGia(10));
}
}
