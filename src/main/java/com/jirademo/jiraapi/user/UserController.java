package com.jirademo.jiraapi.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController{


  private final UserService service;


  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping("")
  public List<User> getUser() {
    return service.getuser();
  }
}
