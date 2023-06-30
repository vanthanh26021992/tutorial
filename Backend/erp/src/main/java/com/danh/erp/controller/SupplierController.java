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

import com.danh.erp.dto.Supplier;
import com.danh.erp.mapper.SupplierMapper;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
@Autowired
private SupplierMapper supMapper;

@GetMapping("get-all")
public List<Supplier> selectAll() {
  return supMapper.selectAll();
}

@GetMapping("get-by-code/{code}")
public Supplier selectByCode(@PathVariable String code) {
  return supMapper.selectByCode(code);
}

@PostMapping("insert")
public void insert(@RequestBody Supplier supplier) {
  supMapper.insert(supplier);
}

@PutMapping("update")
public void update(@RequestBody Supplier supplier) {
  supMapper.update(supplier);
}

@DeleteMapping("delete-by-id/{id}")
public void delete(@PathVariable Long id){
  supMapper.deleteById(id);
}
}
