package com.jirademo.jiraapi.project;

import com.jirademo.jiraapi.issue.Issue;
import com.jirademo.jiraapi.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProjectDto {
  private String name;
  private String description;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Category category;
}
