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

import com.danh.erp.dto.Account;
import com.danh.erp.mapper.AcountMapper;
import com.danh.erp.mapper.EmployeeMapper;

@RestController
@RequestMapping("/account")
public class AcountController {

	// design pattern, solid
	// IOC: AppplicationContext 
	// layer
	
 // @Autowired
  private AcountMapper mapper ;
  
  @Autowired
  private EmployeeMapper eMapper;

  public AcountController(AcountMapper mapper) {
	  this.mapper = mapper;
}
  
  @Autowired
  public void setMapper(AcountMapper mapper) {
	  this.mapper = mapper;
  }
  
  @GetMapping("get-all")
  public List<Account> selectAll() {
    return mapper.selectAll();
  }

  @GetMapping("get-account")
  public Account selectByName(@RequestBody Account account) {
    return mapper.selectByAccount(account);
  }
  
  @GetMapping("getbyusername/{username}")
  public Account selectByUsername(@PathVariable String username) {
    return mapper.selectByUsername(username);
  }
  
  @GetMapping("get-account-by-name-pass/{username}/{password}")
  public Account selectByUsernameAndPass(@PathVariable String username,@PathVariable String password) {
    return mapper.selectByUsernameAndPass(username,password);
  }

  @PostMapping("insert")
  public void insert(@RequestBody Account account) {
    mapper.insert(account);
  }

  @PutMapping("update")
  public void update(@RequestBody Account account) {
    mapper.update(account);
  }

  @DeleteMapping("delete/{id}")
  public void deleteById(@PathVariable("id") Long id) {
    mapper.deleteById(id);
    eMapper.deleteByAccountId(id);
  }
}
