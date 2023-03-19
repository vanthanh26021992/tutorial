 package com.javacore.video53;

import java.util.Arrays;

public class ViDu {
public static void main(String[] args) {
//	Kiểu nguyên thủy
	int[] mang1 = {1,2,3};
//	coppy mảng cách 1
	int[] mang1_a = mang1;
	mang1_a[0]=100;
	System.out.println(Arrays.toString(mang1));
	System.out.println(Arrays.toString(mang1_a));
//	coppy mảng cách 2
	int[] mang1_b = mang1.clone();
	mang1_a[0]=50;
	System.out.println(Arrays.toString(mang1));
	System.out.println(Arrays.toString(mang1_a));
	System.out.println(Arrays.toString(mang1_b));
//	copy mảng cách 3
	int[] mang1_c = new int[mang1.length]; 
	System.arraycopy(mang1, 0, mang1_c, 0, mang1.length);
	mang1_c[0]=90;
	System.out.println(Arrays.toString(mang1));
	System.out.println(Arrays.toString(mang1_a));
	System.out.println(Arrays.toString(mang1_b));
	System.out.println(Arrays.toString(mang1_c));
	
	
}
}
