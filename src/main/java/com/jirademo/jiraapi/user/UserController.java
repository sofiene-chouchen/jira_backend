package com.jirademo.jiraapi.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
@DeleteMapping("/{id}")
public void deleteUser(@PathVariable Integer id ){
    service.deleteUser(id);
}
}
