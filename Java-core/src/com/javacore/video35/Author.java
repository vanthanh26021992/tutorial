package com.javacore.video35;

public class Author {
private String name;
private MyDate Date;


public Author(String name, MyDate date) {
	super();
	this.name = name;
	Date = date;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public MyDate getDate() {
	return Date;
}
public void setDate(MyDate date) {
	Date = date;
}

@Override
public String toString() {
	return "Author [name=" + name + ", Date=" + Date + "]";
}


}
