package com.danh.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danh.erp.dto.Product;
import com.danh.erp.mapper.ProductMapper;
import com.danh.erp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductMapper proMapper;
  
  @Autowired
  private ProductService service;

  @GetMapping("/get-all")
  public List<Product> selectAll() {
    return proMapper.selectAll();
  }
  
  @GetMapping("/search-by-name")
  public List<Product> searchProductByName(@RequestParam(name = "name") String name) {
    return service.searchProductByName(name);
  }

  @GetMapping("get-by-code/{code}")
  public Product selectByCode(@PathVariable String code) {
    return proMapper.selectByCode(code);
  }
  
  @GetMapping("get-by-id/{id}")
  public Product selectByCode(@PathVariable Long id) {
    return proMapper.selectById(id);
  }

  @PostMapping("insert")
  public void insert(@RequestBody Product product) {
    proMapper.insert(product);
  }

  @PutMapping("update")
  public void update(@RequestBody Product product) {
    proMapper.update(product);
  }

  @DeleteMapping("delete-by-id/{id}")
  public void delete(@PathVariable Long id){
    proMapper.deleteById(id);
  }
}
