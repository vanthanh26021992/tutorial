package com.javacore.video57;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TaiXiu {
	public static void main(String[] args) {
		double taiKhoanNguoiChoi = 5000;
		Scanner sc = new Scanner(System.in);

		//	Locale lc = new Locale("vi","VN");
		Locale lc = new Locale("en","US");
		//	NumberFormat numf = NumberFormat.getInstance(lc);
		NumberFormat numf = NumberFormat.getCurrencyInstance(lc); 

		numf.format(taiKhoanNguoiChoi);

		int luaChon = 1;
		try {
			do {
				System.out.println("-----Moi ban lua chon-----");
				System.out.println("Chon 1 de tiep tuc choi");
				System.out.println("Chon phim 0 de thoat");
				luaChon = sc.nextInt();
				int chonTaiXiu =0;
				double tienCuoc;
				if (luaChon==1) {
					do {
						System.out.println("Moi ban lua chon: ");
						System.out.println("Chon 1: Tai");
						System.out.println("Chon 2: Xiu");
						chonTaiXiu = sc.nextInt();
					} while (chonTaiXiu!=1&&chonTaiXiu!=2);

					do {
						System.out.println("So tien trong tai khoan cua ban: "+numf.format(taiKhoanNguoiChoi));
						System.out.println("Moi ban dien so tien cuoc ");
						System.out.println("Neu ban het tien hay nhan 0 ");
						tienCuoc = sc.nextDouble();
					} while (tienCuoc>taiKhoanNguoiChoi||taiKhoanNguoiChoi<0);

					
					Random xucXac = new Random();
					
					int giaTri1 = xucXac.nextInt(5)+1;
					int giaTri2 = xucXac.nextInt(5)+1;
					int giaTri3 = xucXac.nextInt(5)+1;
					int tong = giaTri1+giaTri2+giaTri3;
					
					System.out.println("***Ket qua: "+giaTri1+" - "+giaTri2+" - "+giaTri3);
					
					if (tong==3||tong==18) {
						System.out.println("You lost:");
						taiKhoanNguoiChoi-=tienCuoc;
						System.out.println("So tien trong tai khoan cua ban: "+numf.format(taiKhoanNguoiChoi));
					} else if (tong>3||tong<11) {
						if (chonTaiXiu==1) {
							System.out.println("Tong diem: "+tong+" ==>xiu");
							System.out.println("You lost:");
							taiKhoanNguoiChoi-=tienCuoc;
							System.out.println("So tien trong tai khoan cua ban: "+numf.format(taiKhoanNguoiChoi));
						} else {
							System.out.println("Tong diem: "+tong+" ==>xiu");
							System.out.println("You Win:");
							taiKhoanNguoiChoi+=tienCuoc;
							System.out.println("So tien trong tai khoan cua ban: "+numf.format(taiKhoanNguoiChoi));
						}
					}else{
						if (chonTaiXiu==2) {
							System.out.println("Tong diem: "+tong+" ==>Tai");
							System.out.println("You lost:");
							taiKhoanNguoiChoi-=tienCuoc;
							System.out.println("So tien trong tai khoan cua ban: "+numf.format(taiKhoanNguoiChoi));
						} else {
							System.out.println("Tong diem: "+tong+" ==>Tai");
							System.out.println("You Win:");
							taiKhoanNguoiChoi+=tienCuoc;
							System.out.println("So tien trong tai khoan cua ban: "+numf.format(taiKhoanNguoiChoi));
						}
					}
				}
				if (luaChon==0) {
					break;
				}
			} while (true);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
