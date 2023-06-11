package com.danh.erp.dto;

public class Supplier {
  private long id;
  private String supplierCode;
  private String supplierName;
  private String address;
  private String email;
  private String phone;
  
  public Supplier(long id, String supplierCode, String supplierName, String address, String email, String phone) {
    this.id = id;
    this.supplierCode = supplierCode;
    this.supplierName = supplierName;
    this.address = address;
    this.email = email;
    this.phone = phone;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSupplierCode() {
    return supplierCode;
  }

  public void setSupplierCode(String supplierCode) {
    this.supplierCode = supplierCode;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  
}
