package com.jirademo.jiraapi.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository repository;


  public UserService(UserRepository repository) {
    this.repository = repository;
  }


  public List<User> getuser (){
    return repository.findAll();
  }
  public void deleteUser(Integer id){
    repository.deleteById(id);
  }
}
