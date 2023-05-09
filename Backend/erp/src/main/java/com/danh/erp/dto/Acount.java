package com.danh.erp.dto;

public class Acount {
  // add username and password
  private String name;
  private int age;
  private String phone;
  private String address;
  private String male;
  
  public Acount() {
  }

  public Acount(String name, int age, String phone, String address, String male) {
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.address = address;
    this.male = male;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getMale() {
    return male;
  }

  public void setMale(String male) {
    this.male = male;
  }
  
  
}
