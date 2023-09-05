package com.jirademo.jiraapi.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository repository;


  public UserService(UserRepository repository) {
    this.repository = repository;
  }


  public List<User> getuser (){
    return repository.findAll();
  }
}
