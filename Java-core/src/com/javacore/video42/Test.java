package com.javacore.video42;

public class Test {
public static void main(String[] args) {
  System.out.println("dog");
  Dog d = new Dog();
  d.eat();
  d.makeSound();

  System.out.println("Cat");
  Cat cat = new Cat();
  cat.eat();
  cat.makeSound();
  
  System.out.println("Bird");
  Bird bird = new Bird();
  bird.eat();
  bird.makeSound();
}
}
