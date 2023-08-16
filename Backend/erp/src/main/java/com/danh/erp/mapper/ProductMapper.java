package com.danh.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.danh.erp.dto.Product;

@Mapper
public interface ProductMapper {
  List<Product> selectAll();
  
  List<Product> searchProductByName(@Param("name") String name);
  
  Product selectById(@Param("id") Long id);
  Product selectByCode(@Param("code") String code);
  
  int insert(@Param("product") Product product);
  
  int update(@Param("product") Product product);
  
  int deleteById(@Param("id") Long id);
}
