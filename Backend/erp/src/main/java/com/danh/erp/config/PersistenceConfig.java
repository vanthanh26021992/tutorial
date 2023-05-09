package com.danh.erp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.danh.erp.mapper")
public class PersistenceConfig {

}
