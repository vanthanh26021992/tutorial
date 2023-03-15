package com.javacore.video45;

public class Manufacturer {
  private String manufactureName;
  private String countryName;
  
  public Manufacturer(String manufactureName, String countryName) {
    this.manufactureName = manufactureName;
    this.countryName = countryName;
  }

  public String getManufactureName() {
    return manufactureName;
  }

  public void setManufactureName(String manufactureName) {
    this.manufactureName = manufactureName;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }
  
  
}
