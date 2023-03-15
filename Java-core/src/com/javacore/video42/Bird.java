package com.javacore.video42;

public class Bird extends Animal {

  public Bird() {
    super("Bird");
  }
  
  public void fly() {
    System.out.println("fly");
  }

  @Override
  public void eat() {
System.out.println("Sâu");
  }

  @Override
  public void makeSound() {
System.out.println("líu lo");
  }
  
  
}
