package com.jirademo.jiraapi.issue;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class IssueRequest {
  private Integer id;

  private String title;

  private IssueType type;

  private IssuePriority priority;

  private IssueStatus status;

  private Double listPosition;

  private String description;

  private String descriptionText;

  private Integer estimate;

  private Integer timeSpent;

  private Integer timeRemaining;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private Integer reporterId;

  @Nullable
  private Integer user;

  private Integer project;


}
