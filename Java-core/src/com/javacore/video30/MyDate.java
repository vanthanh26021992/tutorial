package com.javacore.video30;

public class MyDate {
private int day;
private int month;
private int year;

public MyDate() {
	// TODO Auto-generated constructor stub
}

public MyDate(int day, int month, int year) {
	this.day = day;
	this.month = month;
	this.year = year;
}



public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}

public int getMonth() {
	return month;
}

public void setMonth(int month) {
	this.month = month;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public void printDay() {
System.out.println("Day: "+this.day);
}

public void printMonth() {
System.out.println("Day: "+this.month);
}

public void printYear() {
System.out.println("Day: "+this.year);
}

public void printDate() {
System.out.println("Date: "+this.day+"-"+this.month+"-"+this.year);
}

@Override
public String toString() {
	return "MyDate [day=" + day + ", month=" + month + ", year=" + year + "]";
}


}
