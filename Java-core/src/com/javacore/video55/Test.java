package com.javacore.video55;

import java.util.Arrays;

public class Test {
public static void main(String[] args) {
	 int []a = new int[] {1,8,2,6,4,3,7,9};
	 int []b = new int[15];
	 
	 System.out.println(Arrays.toString(a));
	 Arrays.sort(a);
	 System.out.println("Mang sau khi sap xep tang "+Arrays.toString(a));
	 System.out.println(Arrays.binarySearch(a, 0));
	 System.out.println(Arrays.binarySearch(a, 1));
	 System.out.println(Arrays.binarySearch(a, 3));
	 Arrays.fill(b, 5);
	 System.out.println("Mang b "+Arrays.toString(b));
	 a=reverse(a);
	 System.out.println("Mang sau khi dao chieu "+Arrays.toString(a));
	 System.out.println(Arrays.binarySearch(a, 0));
	 System.out.println(Arrays.binarySearch(a, 1));
	 System.out.println(Arrays.binarySearch(a, 3));
}
 static int [] reverse(int [] c) {
	 int [] arr = new int[c.length];
	int d=0;
	for (int i = c.length-1; i >=0; i--) {
		arr[d]=c[i];
		d++;
	}
	return arr;
}
}
