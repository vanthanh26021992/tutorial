package com.danh.erp.dto;

public class Employee {
  private Long id;
  private Long accountId;
  private String username;
  private String password;
  private String fullname;
  private int age;
  private String phone;
  private String address;
  private String gender;
  private String startDate;
  private String department;
  private String endDate;
  private Long salary;
  private String status;
  
  public Employee() {
  }

  public Employee(Long id, long accountId, String username, String password, String fullname, int age, String phone,
      String address, String gender, String startDate, String department, String endDate, Long salary, String status) {
    this.id = id;
    this.accountId = accountId;
    this.username = username;
    this.password = password;
    this.fullname = fullname;
    this.age = age;
    this.phone = phone;
    this.address = address;
    this.gender = gender;
    this.startDate = startDate;
    this.department = department;
    this.endDate = endDate;
    this.salary = salary;
    this.status = status;
  }

  public Employee(Long id, long accountId, String startDate, String department, String endDate, Long salary,
      String status) {
    this.id = id;
    this.accountId = accountId;
    this.startDate = startDate;
    this.department = department;
    this.endDate = endDate;
    this.salary = salary;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  public long getAccountId() {
    return accountId;
  }

  public void setAccountId(long accountId) {
    this.accountId = accountId;
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

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public Long getSalary() {
    return salary;
  }

  public void setSalary(Long salary) {
    this.salary = salary;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
  
}
