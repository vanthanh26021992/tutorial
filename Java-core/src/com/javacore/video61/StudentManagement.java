package com.javacore.video61;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int choose = 0;
      ArrayList<Student> list = new ArrayList<Student>(); 

      do {
        System.out.println("*** Phan mem quan ly sinh vien ***");
        System.out.println("*** Moi chon ***");
        System.out.println("1: Them sinh vien vao danh sach: ");
        System.out.println("2: Kiem tra danh sach sinh vien co rong hay khong: ");
        System.out.println("3: Lay ra so luong sinh vien tong danh sach: ");
        System.out.println("4: Lam rong danh sach sinh vien: ");
        System.out.println("5: Tim kiem sinh vien theo ma sinh vien: ");
        System.out.println("6: Tim kiem sinh vien theo ten sinh vien: ");
        System.out.println("7: Xoa sinh vien theo ma sinh vien: ");
        System.out.println("8: Xuat ra danh sach sinh vien theo diem giam dan: ");

        choose = sc.nextInt();
        switch (choose) {
        case 1:
          System.out.println("1: Them sinh vien vao danh sach: ");
          System.out.println("Nhap vao ma sinh vien: ");
          int a = sc.nextInt();
          System.out.println("Nhap vao ten sinh vien: ");
          String b = sc.nextLine();
          b = sc.nextLine();
          System.out.println("Nhap vao nam sinh cua sinh vien: ");
          int c = sc.nextInt();
          System.out.println("Nhap vao diem trung binh cua sinh vien: ");
          Double d = sc.nextDouble();
          Student std = new Student(a, b, c, d);
          list.add(std);
          break;

        case 2:
          System.out.println("2: Kiem tra danh sach sinh vien co rong hay khong: ");
          if (list.size()==0) {
            System.out.println("list rong");
          } else {
            System.out.println("list co chua sinh vien");
          }
          break;

        case 3:
          System.out.println("So luong sinh vien trong danh sach la: "+list.size());
          break;

        case 4:

          break;

        case 5:

          break;

        case 6:

          break;

        case 7:

          break;

        case 8:

          break;

        default:
          break;
        }


      } while (true);
    }

  }
  
  /*
   * Why Does the scanner.nextLine() Call Get Skipped After the scanner.nextInt() Call?
This behavior is not exclusive to just the scanner.nextInt() method. If you call the scanner.nextLine() method after any of the other scanner.nextWhatever() methods, the program will skip that call.

Well, this has to do with how the two methods work. The first scanner.nextLine() prompts the user for their name.

When the user inputs the name and presses enter, scanner.nextLine() consumes the name and the enter or the newline character at the end.

Which means the input buffer is now empty. Then the scanner.nextInt() prompts the user for their age. The user inputs the age and presses enter.

Unlike the scanner.nextLine() method, the scanner.nextInt() method only consumes the integer part and leaves the enter or newline character in the input buffer.

When the third scanner.nextLine() is called, it finds the enter or newline character still existing in the input buffer, mistakes it as the input from the user, and returns immediately.

As you can see, like many real life problems, this is caused by misunderstanding between the user and the programmer.

There are two ways to solve this problem. You can either consume the newline character after the scanner.nextInt() call takes place, or you can take all the inputs as strings and parse them to the correct data type later on.
   */
}
