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
System.out.println("S�u");
  }

  @Override
  public void makeSound() {
System.out.println("l�u lo");
  }
  
  
}
