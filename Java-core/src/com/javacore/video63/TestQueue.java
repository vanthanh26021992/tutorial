package com.javacore.video63;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TestQueue {
public static void main(String[] args) {
	 Queue<String> listStudent = new LinkedList<String>();
	 listStudent.offer("Nguyen Van A");
	 listStudent.offer("Nguyen Van B");
	 listStudent.offer("Nguyen Van C");
	 listStudent.offer("Nguyen Van E");
	 listStudent.offer("Nguyen Van D");
	 
	 listStudent.add("a");
//	 listStudent.addAll(listStudent); - add them 1 list vao sau cung
//	 listStudent.clear();  - Xoa toan bo list
//	 Contains - kiem tra 1 phan tu co trong Queue hay khong
	 System.out.println(listStudent.contains("a"));
	 System.out.println(listStudent.element());
//	 listStudent.element();
//	 listStudent.forEach(null);
	 
	 
	 while (true) {
		// poll Lay ra va xoa
//		 peek lay ra nhung khong xoa
		String name = listStudent.poll(); 
		if (name==null) {
			break;
		}
		System.out.println(name);
	}
}
}
