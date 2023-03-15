package com.javacore.video45;

public abstract class Transport{
  private String transportation;
  private Manufacturer manufacturer;




  public Transport(String transportation, Manufacturer manufacturer) {
    this.transportation = transportation;
    this.manufacturer = manufacturer;
  }

  public String getTransportation() {
    return transportation;
  }

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  public void setTransportation(String transportation) {
    this.transportation = transportation;
  }
  
  public String manufactureName() {
    return manufacturer.getManufactureName();
  }

  public void start() {
    System.out.println("Bắt đầu chạy");
  }
  
  public void acceleration() {
    System.out.println("Tăng tốc");
  }
  
  public void stop() {
    System.out.println("dừng lại");
  }
  
  public abstract double getSpeed();
}
