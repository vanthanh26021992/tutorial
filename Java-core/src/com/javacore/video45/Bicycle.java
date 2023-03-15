package com.javacore.video45;

public class Bicycle extends Transport{



  public Bicycle(String transportation, Manufacturer manufacturer) {
    super(transportation, manufacturer);
  }

  @Override
  public double getSpeed() {
    return 40;
    
  }

}
