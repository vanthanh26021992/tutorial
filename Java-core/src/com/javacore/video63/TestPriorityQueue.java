package com.javacore.video63;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TestPriorityQueue {
public static void main(String[] args) {
//	priorityQueue giong Queue sap xep
	 Queue<String> listStudent = new PriorityQueue<String>();
	 listStudent.offer("Nguyen Van A");
	 listStudent.offer("Nguyen Van B");
	 listStudent.offer("Nguyen Van C");
	 listStudent.offer("Nguyen Van E");
	 listStudent.offer("Nguyen Van D");
	 
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
