package com.danh.erp.config;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class AppCorsConfiguration extends CorsFilter {


  public AppCorsConfiguration(CorsConfigurationSource source) {
    super(source);
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    response.addHeader("Access-Control-Allow-Headers",
        "Access-Control-Allow-Origin, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE,PATCH");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Max-Age", "1800");
    response.setHeader("Access-Control-Allow-Headers", "content-type");
//    response.setHeader("Access-Control-Allow-Origin", "*");
    if (response.getHeader("Access-Control-Allow-Origin") == null)
      response.addHeader("Access-Control-Allow-Origin", "*");
    filterChain.doFilter(request, response);
  }
}
