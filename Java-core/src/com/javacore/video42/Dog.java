package com.javacore.video42;

public class Dog extends Animal {

  public Dog(String name) {
    super(name);
  }
  
  
  public Dog() {
    super("Dog");
  }


  @Override
  public void eat() {
System.out.println("xương");
  }


  @Override
  public void makeSound() {
    System.out.println("Gâu gâu");
  }
  

  
}
