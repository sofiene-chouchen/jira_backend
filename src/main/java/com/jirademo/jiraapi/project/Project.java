package com.jirademo.jiraapi.project;

import com.jirademo.jiraapi.issue.Issue;
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
public class Project {
  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  private String description;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @Enumerated(EnumType.STRING)
  private Category category;

  @OneToMany(mappedBy = "project" , cascade = CascadeType.ALL)
  private List<Issue> issues;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST , CascadeType.MERGE})
  @JoinTable(
          name = "user_project",
          joinColumns = @JoinColumn(name = "Project_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
  )
  private List<User> users;

}
