package com.jirademo.jiraapi.issue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jirademo.jiraapi.comment.Comment;
import com.jirademo.jiraapi.project.Project;
import com.jirademo.jiraapi.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
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

  @Enumerated(EnumType.ORDINAL )
  private IssuePriority priority;

  @Enumerated(EnumType.STRING)
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


  @ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
  @JoinColumn(name = "project_id")
  @JsonIgnore
  private Project project;

  @OneToMany(mappedBy = "issues")
  private List<Comment> comments;


  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
