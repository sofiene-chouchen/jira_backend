package com.jirademo.jiraapi.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CommentRequest {
  private String body;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private Integer issues;

  private Integer user;
}
