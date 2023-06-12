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

import com.danh.erp.dto.Supplier;
import com.danh.erp.mapper.SupplierMapper;

@CrossOrigin(origins = "http://localhost:3000,http://localhost:3001,http://localhost:3002")
@RestController
public class SupplierController {
@Autowired
private SupplierMapper supMapper;

@GetMapping("get-all-supplier")
public List<Supplier> selectAll() {
  return supMapper.selectAll();
}

@GetMapping("get-supplier-by-code")
public Supplier selectByCode(@RequestBody String code) {
  return supMapper.selectByCode(code);
}

@PostMapping("insert-supplier")
public void insert(@RequestBody Supplier supplier) {
  supMapper.insert(supplier);
}

@PutMapping("update-supplier")
public void update(@RequestBody Supplier supplier) {
  supMapper.update(supplier);
}

@DeleteMapping("delete-supplier-by-id/{id}")
public void delete(@PathVariable Long id){
  supMapper.deleteById(id);
}
}
