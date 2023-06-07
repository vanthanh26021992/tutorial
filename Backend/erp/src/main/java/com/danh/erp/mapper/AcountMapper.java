package com.danh.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.danh.erp.dto.Account;

@Mapper
public interface AcountMapper {
  List<Account> selectAll();
  Account selectByAccount(@Param("account") Account acount);
  Account selectByUsername(@Param("username") String username);
  Account selectByUsernameAndPass(@Param("username") String username,@Param("password") String password);
  int insert(@Param("account") Account acount);
  int update(@Param("account") Account acount);
  int deleteById(@Param("id") Long id);
}
