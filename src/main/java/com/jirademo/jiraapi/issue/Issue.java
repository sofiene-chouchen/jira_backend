package com.jirademo.jiraapi.issue;

import com.jirademo.jiraapi.comment.Comment;
import com.jirademo.jiraapi.project.Project;
import com.jirademo.jiraapi.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Issue {
  @Id
  @GeneratedValue
  private Integer id;

  private String title;

  @Enumerated(EnumType.STRING)
  private IssueType type;

  @Enumerated(EnumType.ORDINAL)
  private IssuePriority priority;

  private Double listPosition;

  private String description;

  private String descriptionText;

  private Integer estimate;

  private Integer timeSpent;

  private Integer timeRemaining;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private Integer reporterId;

  @ManyToOne
  @JoinColumn(name = "project_id")
  private Project project;


  @OneToMany(mappedBy = "issues")
  private List<Comment> comments;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
