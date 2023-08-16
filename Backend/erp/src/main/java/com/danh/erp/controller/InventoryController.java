package com.danh.erp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danh.erp.dto.Inventory;
import com.danh.erp.mapper.InventoryMapper;
import com.danh.erp.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
@Autowired
private InventoryService service;
@Autowired
private InventoryMapper inMapper;

@GetMapping("get-all")
public List<Inventory> selectAll(@RequestBody Inventory search) {
	List<String> strings = new ArrayList<>();
  return inMapper.selectAll(search);
}



@GetMapping("get-by-code/{code}")
public Inventory selectByCode(@PathVariable String code) {
  return inMapper.selectByCode(code);
}

@GetMapping("search-by-name")
public Inventory searchInventoryByName(@PathVariable String name) {
  return service.searchInventoryByName(name);
}

@PostMapping("insert")
public void insert(@RequestBody Inventory inventory) {
	service.insert(inventory);
}

@PutMapping("update")
public void update(@RequestBody Inventory inventory) {
	service.update(inventory);
}

@DeleteMapping("delete-by-id/{id}")
public void delete(@PathVariable Long id){
  inMapper.deleteById(id);
}
}
