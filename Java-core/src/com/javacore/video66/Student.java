package com.javacore.video66;

public class Student<T>{
	private T value;

	public Student(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
