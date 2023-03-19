package com.javacore.video59;

public class EnumTest {
public static void main(String[] args) {
	Schedule tkd_t2 = new Schedule(Day.Monday, "Toan, ly, hoa");
	Schedule tkd_t3 = new Schedule(Day.Tueday, "Van, Su, Dia");
	Schedule tkd_t4 = new Schedule(Day.Wednesday, "Ly, Hoa, Sinh");
	Schedule tkd_t5 = new Schedule(Day.Thursday, "Tin, GDCD, The Duc");
	System.out.println(tkd_t5);
	
	int x = Thang.Thang1.soNgay();
	System.out.println(x);
}
}
