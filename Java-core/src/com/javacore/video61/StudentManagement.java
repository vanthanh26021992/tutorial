package com.javacore.video61;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagement {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int choose = 0;
			ArrayList<Student> list = new ArrayList<Student>();

//      làm thêm sửa sinh viên
//      Tính điểm trung bình của cả lớp
//      Tìm điểm cao nhất và thấp nhất
			do {
				System.out.println("---------------------------------");
				System.out.println("*** Phan mem quan ly sinh vien ***");
				System.out.println("*** Moi chon ***");
				System.out.println("1: Them sinh vien vao danh sach: ");
				System.out.println("2: Kiem tra danh sach sinh vien co rong hay khong: ");
				System.out.println("3: Lay ra so luong sinh vien tong danh sach: ");
				System.out.println("4: Lam rong danh sach sinh vien: ");
				System.out.println("5: Kiem tra sinh vien co ton tai trong danh sach theo ma sinh vien: ");
				System.out.println("6: Tim kiem sinh vien theo ten sinh vien: ");
				System.out.println("7: Xoa sinh vien theo ma sinh vien: ");
				System.out.println("8: Xuat ra danh sach sinh vien theo diem giam dan: ");
				System.out.println("9: Xuat ra danh sach sinh vien: ");
				System.out.println("10: Sửa sinh vien: ");
				System.out.println("11: Tính điểm trung bình của cả lớp: ");
				System.out.println("12: Tìm điểm cao nhất và thấp nhất: ");

				choose = sc.nextInt();
				switch (choose) {
				case 1:
					System.out.println("1: Them sinh vien vao danh sach: ");
					System.out.println("Nhap vao ma sinh vien: ");
					int studentCode1 = sc.nextInt();
					System.out.println("Nhap vao ten sinh vien: ");
					String studentName = sc.nextLine();
					studentName = sc.nextLine();
					System.out.println("Nhap vao nam sinh cua sinh vien: ");
					int dateOfBirth1 = sc.nextInt();
					System.out.println("Nhap vao diem trung binh cua sinh vien: ");
					Double mediumScore1 = sc.nextDouble();
					Student std = new Student(studentCode1, studentName, dateOfBirth1, mediumScore1);
					list.add(std);
					break;

				case 2:
					System.out.println("2: Kiem tra danh sach sinh vien co rong hay khong: ");
					if (list.isEmpty()) {
						System.out.println("list rong");
					} else {
						System.out.println("list co chua sinh vien");
					}

//          if (list.size()==0) {
//            System.out.println("list rong");
//          } else {
//            System.out.println("list co chua sinh vien");
//          }
					break;

				case 3:
					System.out.println("So luong sinh vien trong danh sach la: " + list.size());
					break;

				case 4:
					System.out.println("4: Lam rong danh sach sinh vien: ");
					list.clear();
					break;

				case 5:
					System.out.println("5: Kiem tra sinh vien co ton tai trong danh sach theo ma sinh vien: ");
					System.out.println("Nhap ma sinh vien can tim: ");
					int studentCode2 = sc.nextInt();
					Student std1 = new Student(studentCode2);
					if (list.contains(std1)) {
						System.out.println("Sinh vien co ma so " + studentCode2 + " co ton tai");
					} else {
						System.out.println("Sinh vien co ma so " + studentCode2 + " khong ton tai");
					}
					break;

				case 6:
					System.out.println("6: Tim kiem sinh vien theo ten sinh vien: ");
					System.out.println("Nhap ten sinh vien can tim: ");
					String name = sc.nextLine();
					name = sc.nextLine();
					for (Student student : list) {
						if (student.getName().indexOf(name) >= 0) {
							System.out.println(student);

						}
					}
					break;

				case 7:
					System.out.println("7: Xoa sinh vien theo ma sinh vien: ");
					System.out.println("Nhap ma sinh vien can xoa: ");
					int studentCode3 = sc.nextInt();
					Student std2 = new Student(studentCode3);
//        	list.remove(std2);
					if (list.contains(std2)) {
						list.remove(std2);
						System.out.println("Sinh vien co ma so " + studentCode3 + " Da duoc xoa");
					} else {
						System.out.println("Sinh vien co ma so " + studentCode3 + " khong ton tai");
					}
					break;

				case 8:
					System.out.println("8: Xuat ra danh sach sinh vien theo diem giam dan: ");
					Collections.sort(list);
					Collections.reverse(list);
					System.out.println(list.toString());
					break;

				case 9:
					System.out.println("9: Xuat ra danh sach sinh vien: ");
					System.out.println(list.toString());
					break;

				case 10:
					System.out.println("10: Sửa sinh vien: ");
					System.out.println("Nhập tên sinh viên cần sửa:");
					String name1 = sc.nextLine();
					name1=sc.nextLine();
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getName().indexOf(name1) >= 0) {
							System.out.println(list.get(i));
							int choose1 = 0;
							do {
								
								System.out.println("1: Sửa tên");
								System.out.println("2: Sửa năm sinh");
								System.out.println("3: Sửa mã sinh viên");
								System.out.println("4: Sửa điểm trung bình");
								System.out.println("0: Thoát sửa");
								choose1 = sc.nextInt();
								switch (choose1) {
								case 1:
									System.out.println("Nhập tên mới");
									String name2 = sc.nextLine();
									name2 = sc.nextLine();
									list.get(i).setName(name2);
									break;

								case 2:
									System.out.println("Nhập năm mới");
									int date = sc.nextInt();
									list.get(i).setYearOfBirth(date);
									break;
								case 3:
									System.out.println("Nhập mã sinh viên mới");
									int code = sc.nextInt();
									list.get(i).setStudentCode(code);
									break;
								case 4:
									System.out.println("Nhập điểm trung trung bình mới");
									int score = sc.nextInt();
									list.get(i).setMediumScore(score);
									break;
								default:
									break;
								}

							} while (choose1 != 0);
						}
					}
					break;

				case 11:
					System.out.print("Điểm trung bình của cả lớp: ");
					int total=0;
					for (Student student : list) {
						total +=student.getMediumScore();
					}
					int medium = total/list.size();
					System.out.println(medium);
					break;

				case 12:
					Collections.sort(list);
					System.out.println("Điểm cao nhất là: "+list.get(list.size()-1));
					System.out.println("Điểm thấp nhất là: "+list.get(0));
					break;
				default:
					break;
				}

			} while (true);
		}

	}

	/*
	 * Why Does the scanner.nextLine() Call Get Skipped After the scanner.nextInt()
	 * Call? This behavior is not exclusive to just the scanner.nextInt() method. If
	 * you call the scanner.nextLine() method after any of the other
	 * scanner.nextWhatever() methods, the program will skip that call.
	 * 
	 * Well, this has to do with how the two methods work. The first
	 * scanner.nextLine() prompts the user for their name.
	 * 
	 * When the user inputs the name and presses enter, scanner.nextLine() consumes
	 * the name and the enter or the newline character at the end.
	 * 
	 * Which means the input buffer is now empty. Then the scanner.nextInt() prompts
	 * the user for their age. The user inputs the age and presses enter.
	 * 
	 * Unlike the scanner.nextLine() method, the scanner.nextInt() method only
	 * consumes the integer part and leaves the enter or newline character in the
	 * input buffer.
	 * 
	 * When the third scanner.nextLine() is called, it finds the enter or newline
	 * character still existing in the input buffer, mistakes it as the input from
	 * the user, and returns immediately.
	 * 
	 * As you can see, like many real life problems, this is caused by
	 * misunderstanding between the user and the programmer.
	 * 
	 * There are two ways to solve this problem. You can either consume the newline
	 * character after the scanner.nextInt() call takes place, or you can take all
	 * the inputs as strings and parse them to the correct data type later on.
	 */
}
