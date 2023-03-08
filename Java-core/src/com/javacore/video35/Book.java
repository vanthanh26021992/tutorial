
package com.javacore.video35;

public class Book {
	private String name;
	private double price;
	private int publishingYear;
	private Author author;
	
	public Book(String name, double price, int publishingYear, Author author) {
		super();
		this.name = name;
		this.price = price;
		this.publishingYear = publishingYear;
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + ", publishingYear=" + publishingYear + ", author=" + author
				+ "]";
	}
	
	 boolean soSanhNamXuatBan(Book bk) {
		return this.getPublishingYear()==bk.getPublishingYear();
	}
	 
	  double giaSachSauGiamGia(double x) {
		 return this.getPrice()-this.getPrice()*(x/100);
	}
}


