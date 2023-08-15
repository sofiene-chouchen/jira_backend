package com.jirademo.jiraapi.comment;

import com.jirademo.jiraapi.issue.Issue;
import com.jirademo.jiraapi.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {

  @Id
  @GeneratedValue
  private Integer id;

  private String body;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @ManyToOne()
  @JoinColumn(name = "issue_id")
  private Issue issues;
  @ManyToOne()
  @JoinColumn(name = "user_id")
  private User user;
}
