package com.danh.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @GetMapping("/home")
  public String homepage() {
    return "home";
  }
  
  @GetMapping("/")
  public String home() {
    return "Trang chu";
  }
}
