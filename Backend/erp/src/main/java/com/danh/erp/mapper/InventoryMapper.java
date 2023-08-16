package com.danh.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.danh.erp.dto.Inventory;

@Mapper
public interface InventoryMapper {
  List<Inventory> selectAll(@Param("search") Inventory search);
  
  Inventory selectById(@Param("id") Long id);
  
  Inventory selectByCode(@Param("code") String code);
  
  Inventory searchInventoryByName(@Param("name") String name);
  
  Inventory selectByUsernameAndPass(@Param("username") String username,@Param("password") String password);
  
  int insert(@Param("inventory") Inventory inventory);
  
  int update(@Param("inventory") Inventory inventory);
  int updateByCode(@Param("inventory") Inventory inventory);
  
  int deleteById(@Param("id") Long id);
}
