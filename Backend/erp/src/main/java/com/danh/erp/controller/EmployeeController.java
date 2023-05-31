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
import org.springframework.web.bind.annotation.RestController;

import com.danh.erp.dto.Employee;
import com.danh.erp.mapper.EmployeeMapper;
import com.danh.erp.service.EmployeeService;
@CrossOrigin(origins = "http://localhost:3000,http://localhost:3001,http://localhost:3002")
@RestController
public class EmployeeController {
  @Autowired
  private EmployeeMapper eMapper;
  
  @Autowired
  private EmployeeService employeeService;
  
  @GetMapping("getAllEmployee")
  public List<Employee> selectAll(){
    return eMapper.selectAll();
  }
  // layer
  @GetMapping("getEmployeeById/{id}")
  public Employee selectById(@PathVariable int id){
    return eMapper.selectById(id);
  }
  @GetMapping("getEmployeeByUsername/{username}")
  public Employee selectByUsername(@PathVariable String username){
    return eMapper.selectByUsername(username);
  }
  @GetMapping("getEmployeeByUsernameAndPass/{username}/{password}")
  public Employee selectByUsernameAndPass(@PathVariable String username,@PathVariable String password){
    return eMapper.selectByUsernameAndPass(username,password);
  }
  
  @PostMapping("insertEmployee")
  public void insert(@RequestBody Employee employee) {
    System.out.println("got here ================================== ");
    employeeService.insert(employee);
  }
  
  @DeleteMapping("deleteEmployee/{id}")
  public void delete(@PathVariable int id){
     eMapper.deleteById(id);
  }
  
  @PutMapping("updateEmployee")
  public void update(@RequestBody Employee employee){
    System.out.println("got here ==================================  updateEmployee");
    employeeService.update(employee);
  }
}
