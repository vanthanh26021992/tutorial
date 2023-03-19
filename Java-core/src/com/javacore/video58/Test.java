package com.javacore.video58;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {
public static void main(String[] args) {
//	Ham lay thoi gian hien tai
	long t1 = System.currentTimeMillis();
	for (int i = 0; i < 10000; i++) {
		System.out.println("TEST");
	}
	long t2 = System.currentTimeMillis();
	System.out.println("Truoc khi chay for: "+t1);
	System.out.println("Sau khi chay for: "+t2);
	System.out.println("Thoi gian chay for: "+(t2-t1)+"mls");
	System.out.println("Thoi gian chay for: "+(t2-t1)/1000+"s");
	
//	TimeUnit
	System.out.println("3000 nam = "+TimeUnit.DAYS.toSeconds(3000*365)+"s");
	System.out.println("25 gio = "+TimeUnit.HOURS.toSeconds(25)+"s");
	System.out.println(25*60*60);
	System.out.println("3000s = "+TimeUnit.SECONDS.toHours(3000)+" gio");
	System.out.println("3000s = "+TimeUnit.SECONDS.toMinutes(3000)+" phut");
	
//	Date d = new Date();
//	Lay ngay thang nam tai thoi diem nay
	Date d = new Date(System.currentTimeMillis()); 
	System.out.println((d.getDate())+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900));
	System.out.println(d.getDay());
	System.out.println(d.getDate());
	
//	Calendar
	Calendar c = Calendar.getInstance();
	System.out.println(c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR));
	System.out.println(c.toString());
	System.out.println(c.get(Calendar.MONTH));
	c.add(Calendar.HOUR, 30);
	System.out.println(c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR));
	c.add(Calendar.DATE, 14);
	System.out.println(c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR));
	
//	DateFormat
	DateFormat df = new SimpleDateFormat();
	System.out.println(df.format(d));
	
	df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println(df.format(d));
}
}
