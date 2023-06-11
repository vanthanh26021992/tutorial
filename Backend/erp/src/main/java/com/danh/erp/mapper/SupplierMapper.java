package com.danh.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.danh.erp.dto.Employee;
import com.danh.erp.dto.Supplier;

@Mapper
public interface SupplierMapper {
  List<Supplier> selectAll();
  Supplier selectById(@Param("id") Long id);
  Supplier selectByCode(@Param("code") String code);
  Supplier selectByUsername(@Param("username") String username);
  Supplier selectByUsernameAndPass(@Param("username") String username,@Param("password") String password);
  int insert(@Param("supplier") Supplier supplier);
  int update(@Param("supplier") Supplier supplier);
  
  int deleteById(@Param("id") Long id);
}
