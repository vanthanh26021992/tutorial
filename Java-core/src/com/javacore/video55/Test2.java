package com.javacore.video55;

import java.util.Arrays;

public class Test2 {
public static void main(String[] args) {
	Student std1 = new Student(1, "Nguyen Van A", 9);
	Student std2 = new Student(1, "Nguyen Van B", 8);
	Student std3 = new Student(1, "Nguyen Van C", 6);
	
	Student [] arr = new Student[] {std1,std3,std2};
	System.out.println(Arrays.toString(arr));
	Arrays.sort(arr);
	System.out.println(Arrays.toString(arr));
	System.out.println(Arrays.binarySearch(arr, std1));
	System.out.println(Arrays.binarySearch(arr, std2));
}
}
