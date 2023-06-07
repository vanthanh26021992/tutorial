package com.danh.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danh.erp.dto.Account;
import com.danh.erp.dto.Employee;
import com.danh.erp.mapper.AcountMapper;
import com.danh.erp.mapper.EmployeeMapper;

@Service
public class EmployeeService {

  // CRUD
  @Autowired
  private EmployeeMapper eMapper;
  
  @Autowired
  private AcountMapper accountMapper;
  
  
  @Transactional
  public void insert(Employee employee) {
    Account account = new Account();
    account.setUsername(employee.getUsername());
    account.setPassword(employee.getPassword());
    account.setFullname(employee.getFullname());
    account.setAge(employee.getAge());
    account.setPhone(employee.getPhone());
    account.setAddress(employee.getAddress());
    account.setGender(employee.getGender());
    // 
    
    int inserted =  accountMapper.insert(account);
    if(inserted == 1) {
      System.out.println("account id " + account.getId());
      employee.setAccountId(account.getId());
      eMapper.insert(employee);
    }
 }
  
  @Transactional
  public void update(Employee employee) {
    Account account = new Account();
    account.setId(employee.getAccountId());
    account.setUsername(employee.getUsername());
    account.setPassword(employee.getPassword());
    account.setFullname(employee.getFullname());
    account.setAge(employee.getAge());
    account.setPhone(employee.getPhone());
    account.setAddress(employee.getAddress());
    account.setGender(employee.getGender());
    
    int inserted =  accountMapper.update(account);
    if(inserted == 1) {
      System.out.println("account id " + account.getId());
      System.out.println("employee getAccountId " + employee.getAccountId());
//      employee.setAccountId(account.getId());
      
      eMapper.update(employee);
    }
 }
}
