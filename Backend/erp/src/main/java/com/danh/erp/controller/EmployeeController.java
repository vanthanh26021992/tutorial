package com.danh.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danh.erp.dto.Employee;
import com.danh.erp.mapper.AcountMapper;
import com.danh.erp.mapper.EmployeeMapper;
import com.danh.erp.service.EmployeeService;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
  @Autowired
  private EmployeeMapper eMapper;
  @Autowired
  private AcountMapper mapper;
  @Autowired
  private EmployeeService employeeService;
  
  @GetMapping("get-all")
  public List<Employee> selectAll(){
    return eMapper.selectAll();
  }
  // layer
  @GetMapping("get-by-id/{id}")
  public Employee selectById(@PathVariable Long id){
    return eMapper.selectById(id);
  }
  @GetMapping("get-by-username/{username}")
  public Employee selectByUsername(@PathVariable String username){
    return eMapper.selectByUsername(username);
  }
  @GetMapping("get-by-username-and-pass/{username}/{password}")
  public Employee selectByUsernameAndPass(@PathVariable String username,@PathVariable String password){
    return eMapper.selectByUsernameAndPass(username,password);
  }
  
  @PostMapping("insert")
  public void insert(@RequestBody Employee employee) {
    System.out.println("got here ================================== ");
    employeeService.insert(employee);
  }
  
  @DeleteMapping("delete-by-accountId/{accountId}")
  public void delete(@PathVariable Long accountId){
     eMapper.deleteByAccountId(accountId);
     mapper.deleteById(accountId);
  }
  
  @PutMapping("update")
  public void update(@RequestBody Employee employee){
    System.out.println("got here ==================================  updateEmployee");
    employeeService.update(employee);
  }
}
