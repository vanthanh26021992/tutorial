package com.javacore.video56;

import java.util.Arrays;

public class Test {
public static void main(String[] args) {
	String s = "Xin chao cac ban, tui la Peter!";
	String s2 = "Xin chao, tui la Peter. Minh la lap trinh vien!";
	String []a = s.split(" ");
	String []b = s.split(",");
//	Dung \\ neu co nhieu yeu cau | de ngan giua cac yeu cau
	String []c = s2.split("\\,|\\.");
	String []d = s2.split("");
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(b));
	System.out.println(Arrays.toString(c));
	System.out.println(Arrays.toString(d));
}

}
