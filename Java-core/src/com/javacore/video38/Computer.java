package com.javacore.video38;

public class Computer {
	private Manufacturer manufacturer;
	private DateOfManufacture dateOfManufacture;
	private double price;
	private int warrantyPeriod;
	
	public Computer(Manufacturer manufacturer, DateOfManufacture dateOfManufacture, double price, int warrantyPeriod) {
		super();
		this.manufacturer = manufacturer;
		this.dateOfManufacture = dateOfManufacture;
		this.price = price;
		this.warrantyPeriod = warrantyPeriod;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public DateOfManufacture getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(DateOfManufacture dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}
	
	public boolean checkPrice(Computer cpu) {
		return this.price<cpu.price;
	}
	
	public String nationName() {
		return this.manufacturer.getNation().getCountryName();

	}
}
