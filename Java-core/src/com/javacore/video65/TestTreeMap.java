package com.javacore.video65;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
public static void main(String[] args) {
	Map<String, String> map = new TreeMap<String, String>();
	map.put("medium", "trung bình");
	map.put("agency", "hãng");
	map.put("look", "nhìn");
	map.put("kitchen", "phòng bếp");
	map.put("bea", "cưng");
	
	System.out.println(map.toString());
//	map.clear();		- xóa hết
//	map.remove("look");  - Xóa từ
	map.replace("bea", "cứng");
	System.out.println(map.toString());
	System.out.println(map.keySet());
	System.out.println(map.isEmpty());
	System.out.println(map.containsKey("look"));
	System.out.println(map.toString());
	System.out.println(map.values());
	System.out.println(map.size());
//	tra từ
	System.out.println(map.get("look")); 
}
}
