package com.javacore.video40;

public class Test {
public static void main(String[] args) {
  Dog d = new Dog();
  d.eat();
  d.bark();
  System.out.println("baby dog");
  BabyDog bbd = new BabyDog();
  bbd.eat();
  bbd.bark();
  bbd.weep();
  System.out.println("Cat");
  Cat cat = new Cat();
  cat.eat();
  cat.meow();
  System.out.println("Bird");
  Bird bird = new Bird();
  bird.eat();
  bird.fly();
}
}
