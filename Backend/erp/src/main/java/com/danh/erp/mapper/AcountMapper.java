package com.danh.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.danh.erp.dto.Acount;

@Mapper
public interface AcountMapper {
  List<Acount> selectAll();
  Acount selectByName(@Param("name") String name);
  int insert(@Param("acount") Acount acount);
  int update(@Param("acount") Acount acount);
  int deleteByName(@Param("name") String name);
}
