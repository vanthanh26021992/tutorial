package com.danh.erp.dto;

public class Inventory {
private long id;
private String productCode;
private String productName;
private String unit;
private int quantity;
private long priceBuy;
private long priceTotal;
private String date;

public Inventory(long id, String productCode, String productName, String unit, int quantity, long priceBuy,
		long priceTotal, String date) {
	this.id = id;
	this.productCode = productCode;
	this.productName = productName;
	this.unit = unit;
	this.quantity = quantity;
	this.priceBuy = priceBuy;
	this.priceTotal = priceTotal;
	this.date = date;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public long getId() {
  return id;
}

public void setId(long id) {
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

public int getQuantity() {
  return quantity;
}

public void setQuantity(int quantity) {
  this.quantity = quantity;
}

public long getPriceBuy() {
  return priceBuy;
}

public void setPriceBuy(long priceBuy) {
  this.priceBuy = priceBuy;
}

public long getPriceTotal() {
  return priceTotal;
}

public void setPriceTotal(long priceTotal) {
  this.priceTotal = priceTotal;
}


}
