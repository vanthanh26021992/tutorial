package com.javacore.video38;

public class Test {
	public static void main(String[] args) {
		Nation na1 = new Nation("My", 0001);
		Nation na2 = new Nation("Nhat", 0002);
		Nation na3 = new Nation("Phap", 0003);
		Manufacturer mft1 = new Manufacturer("hang 1", na1);
		Manufacturer mft2 = new Manufacturer("hang 2", na2);
		Manufacturer mft3 = new Manufacturer("hang 3", na3);
		DateOfManufacture dom1 = new DateOfManufacture(1, 10, 2020);
		DateOfManufacture dom2 = new DateOfManufacture(2, 11, 2021);
		DateOfManufacture dom3 = new DateOfManufacture(3, 12, 2022);
		Computer cpu1 = new Computer(mft1, dom1, 1000, 36);
		Computer cpu2 = new Computer(mft2, dom2, 2000, 36);
		Computer cpu3 = new Computer(mft3, dom3, 1000, 36);
		
		System.out.println("Kiểm tra giá bán của máy tính 1 có thấp hơn máy tính 2 không: "+cpu1.checkPrice(cpu2));
		System.out.println("Kiểm tra giá bán của máy tính 1 có thấp hơn máy tính 3 không: "+cpu1.checkPrice(cpu3));
		System.out.println("Kiểm tra tên quốc gia sản xuất của máy tính 1: "+cpu1.nationName());
		System.out.println("Kiểm tra tên quốc gia sản xuất của máy tính 2: "+cpu2.nationName());
		System.out.println("Kiểm tra tên quốc gia sản xuất của máy tính 3: "+cpu3.nationName());
	}
}
