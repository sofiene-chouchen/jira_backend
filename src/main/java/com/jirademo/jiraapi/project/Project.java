package com.jirademo.jiraapi.project;

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
public class Project {
  @Id
  @GeneratedValue
  private Integer id ;

  private String name ;

  private String description ;

  private LocalDateTime createdAt ;

  private LocalDateTime updatedAt ;
  @Enumerated(EnumType.STRING)
  private Category category;

  @ManyToMany(mappedBy = "projects")
  private List<User>  users ;

}
