package com.danh.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.danh.erp.dto.Employee;

@Mapper
public interface EmployeeMapper {
  List<Employee> selectAll();
  Employee selectById(@Param("id") Long id);
  Employee selectByUsername(@Param("username") String username);
  Employee selectByUsernameAndPass(@Param("username") String username,@Param("password") String password);
  int insert(@Param("employee") Employee employee);
  int update(@Param("employee") Employee employee);
  int deleteByAccountId(@Param("accountId") Long accountId);
}
