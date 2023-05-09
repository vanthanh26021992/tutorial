package com.danh.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danh.erp.dto.Acount;
import com.danh.erp.mapper.AcountMapper;

@CrossOrigin(origins = "http://localhost:3000,http://localhost:3001,http://localhost:3002")
@RestController
public class AcountController {

  @Autowired
  private AcountMapper mapper;

  @GetMapping("get-all")
  public List<Acount> selectAll() {
    return mapper.selectAll();
  }

  @GetMapping("get-by-username/{name}")
  public Acount selectByName(@PathVariable("name") String name) {
    return mapper.selectByName(name);
  }

  @PostMapping("insert")
  public void insert(Acount acount) {
    mapper.insert(acount);
  }

  @PutMapping("update")
  public void update(Acount acount) {
    mapper.update(acount);
  }

  @DeleteMapping("delete/{name}")
  public void deleteByName(@PathVariable("name") String name) {
    mapper.deleteByName(name);
  }
}
