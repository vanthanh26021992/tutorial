package com.javacore.video59;

public enum Thang {
	Thang1(31),
	Thang2(29),
	Thang3(31),
	Thang4(30),
	Thang5(31),
	Thang6(30),
	Thang7(31),
	Thang8(31),
	Thang9(30),
	Thang10(31),
	Thang11(30),
	Thang12(31);
	
	private final int soNgay;

	
	public int soNgay() {
		return soNgay;
	}

	private Thang(int soNgay) {
		this.soNgay = soNgay;
	}
	
}
