package com.javacore.video32;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) {
		super();
		if (day>=1&&day<=31) {
			this.day = day;
		}
		
		if (month>=1&&month<=12) {
			this.month = month;
		}
		
		if (year>0) {
			this.year = year;
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day>=1&&day<=31) {
			this.day = day;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month>=1&&month<=12) {
			this.month = month;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year>0) {
			this.year = year;
		}
	}
}
