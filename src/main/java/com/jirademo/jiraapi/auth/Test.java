package com.jirademo.jiraapi.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Test {
  @GetMapping("/test")
  public String test(){
    return "heloow";
  }
}
