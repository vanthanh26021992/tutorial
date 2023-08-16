package com.danh.erp.dto;

public class Account {
  private long id;
  private String username;
  private String password;
  private String fullname;
  private int age;
  private String phone;
  private String address;
  private String gender;
  private String create_date;
  private String update_date;
  
  public Account() {
    super();
  }
  
  public Account(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Account(long id, String username, String password, String fullname, int age, String phone, String address,
		String gender, String create_date, String update_date) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.fullname = fullname;
	this.age = age;
	this.phone = phone;
	this.address = address;
	this.gender = gender;
	this.create_date = create_date;
	this.update_date = update_date;
}

public String getCreate_date() {
	return create_date;
}

public void setCreate_date(String create_date) {
	this.create_date = create_date;
}

public String getUpdate_date() {
	return update_date;
}

public void setUpdate_date(String update_date) {
	this.update_date = update_date;
}

public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getFullname() {
    return fullname;
  }
  public void setFullname(String fullname) {
    this.fullname = fullname;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
}
