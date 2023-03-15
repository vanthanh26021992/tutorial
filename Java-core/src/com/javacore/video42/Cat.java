package com.javacore.video42;

public class Cat extends Animal {

  public Cat() {
    super("Cat");
  }
  


  @Override
  public void eat() {
System.out.println("cá");
  }

  @Override
  public void makeSound() {
    System.out.println("meo meo");
  }
  
  
}
