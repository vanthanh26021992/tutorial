package com.javacore.video42;

public class Animal {
	protected String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println("eating");
	}
	
	public void sleep() {
	  System.out.println("Zzzzzzzzz");
  }
	
	public void makeSound() {
    System.out.println("...............");
  }
}
