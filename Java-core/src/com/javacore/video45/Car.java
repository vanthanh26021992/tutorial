package com.javacore.video45;

public class Car extends Transport{
  private String fuel;



  
  public Car(String transportation, Manufacturer manufacturer, String fuel) {
    super(transportation, manufacturer);
    this.fuel = fuel;
  }


  public String getFuel() {
    return fuel;
  }


  public void setFuel(String fuel) {
    this.fuel = fuel;
  }


  @Override
  public double getSpeed() {
    return 100;
  }
  
  
}
