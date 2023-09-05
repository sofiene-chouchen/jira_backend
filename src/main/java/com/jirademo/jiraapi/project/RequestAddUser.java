package com.jirademo.jiraapi.project;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RequestAddUser {

  private Integer projectId;

  private Integer userId;

}
