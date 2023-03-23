package com.javacore.video64;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RutThamTrungThuong_Treeset {
	public static void main(String[] args) {
		Set<Integer> list = new TreeSet<Integer>();
		Scanner sc = new Scanner(System.in);
		int choose=0;
		int lotteryCode;
		
		do {
			System.out.println("------------------------");
			System.out.println("1: Thêm mã số dự thưởng: ");
			System.out.println("2: Xóa mã số dự thưởng: ");
			System.out.println("3: Kiểm tra mã số dự thưởng có tồn tại hay không:");
			System.out.println("4: Xóa tất cả mã số dự thưởng:");
			System.out.println("5: Số lượng mã số dự thưởng:");
			System.out.println("6: Rút thăm trúng thưởng:");
			System.out.println("7: In ra tất cả các mã:");
			System.out.println("0: Thoát khỏi chương trình:");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Mời điền mã số dự thưởng:");
				lotteryCode = sc.nextInt();
				list.add(lotteryCode);
				break;
			case 2:
				System.out.println("Mời điền mã số dự thưởng cần xóa:");
				 lotteryCode = sc.nextInt();
				list.remove(lotteryCode);
				break;
			case 3:
				System.out.println("Mời điền mã số dự thưởng cần kiểm tra:");
				 lotteryCode = sc.nextInt();
				list.contains(lotteryCode);
				break;
			case 4:
				System.out.println("Xóa hết các mã số dự thưởng:");
				list.clear();
				break;
			case 5:
				System.out.println("Số lượng mã số dự thưởng:");
				list.size();
				break;
			case 6:
				System.out.println("Mã số dự thưởng của bạn là:");
				break;
			case 7:
				System.out.println("In ra tất cả mã số dự thưởng:");
//				list.toString();
				System.out.println(list.toString());
				break;

			default:
				break;
			}
		} while (choose!=0);
	}
}
