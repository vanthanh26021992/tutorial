package com.javacore.video45;

public class Plane extends Transport{
  private String fuel;



  public Plane(String transportation, Manufacturer manufacturer, String fuel) {
    super(transportation, manufacturer);
    this.fuel = fuel;
  }

  public String getFuel() {
    return fuel;
  }

  public void setFuel(String fuel) {
    this.fuel = fuel;
  }

  public void takeOff() {
    System.out.println("Cất cánh");
  }
  
  public void landing() {
    System.out.println("Hạ cánh");
  }
  
  @Override
  public double getSpeed() {
    return 500;
  }
  
  
}
