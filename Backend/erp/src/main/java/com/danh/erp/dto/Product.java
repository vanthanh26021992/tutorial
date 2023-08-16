package com.danh.erp.dto;

public class Product {
private Long id;
private String productCode;
private String productName;
private String unit;

public Product(Long id, String productCode, String productName, String unit) {
  super();
  this.id = id;
  this.productCode = productCode;
  this.productName = productName;
  this.unit = unit;
}

public Long getId() {
  return id;
}

public void setId(Long id) {
  this.id = id;
}

public String getProductCode() {
  return productCode;
}

public void setProductCode(String productCode) {
  this.productCode = productCode;
}

public String getProductName() {
  return productName;
}

public void setProductName(String productName) {
  this.productName = productName;
}

public String getUnit() {
  return unit;
}

public void setUnit(String unit) {
  this.unit = unit;
}

}
