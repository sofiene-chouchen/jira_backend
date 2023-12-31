package com.jirademo.jiraapi.project;


import com.jirademo.jiraapi.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RequestAddUser {

  private Integer projectId;

  private List<Integer> userId;


}
