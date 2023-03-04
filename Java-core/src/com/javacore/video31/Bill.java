package com.javacore.video31;

public class Bill {
	private String name;
	private double quantity;
	private double price;
	

	public Bill(String name, double quantity, double price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double total() {
		return this.price*this.quantity;
	}
	
//	So sánh xem khối lượng nhập vào có lớn hơn khối lượng cần so mua không
	public boolean compare(double kl) {
		return this.quantity > kl;
	}
	
//	So sánh xem giá tiền của hóa đơn có lớn hơn 50000 hay không
	public boolean compare1() {
		return this.total() > 50000;
	}
	
//	Tính số tiền giảm giá, giảm 10% cho các hóa đơn có giá trị lớn hơn 500000đ
	public double discount() {
		return (this.total() > 500000)?this.total()/10 : 0;
	}
	
//	Tính số tiền khách còn phải trả sau khi giảm giá
	public double theMoneyHaveToPay() {
		return this.total()-discount();
	}
}
