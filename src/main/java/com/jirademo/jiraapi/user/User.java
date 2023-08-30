package com.jirademo.jiraapi.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jirademo.jiraapi.comment.Comment;
import com.jirademo.jiraapi.issue.Issue;
import com.jirademo.jiraapi.project.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;

  private String name;

  private String email;

  private String password;

  private String avatarUrl;

  private LocalDateTime createdAt;

  private LocalDateTime updateAt;

  @Enumerated(EnumType.STRING)
  private Role role;

  @JsonIgnore
  @ManyToMany(mappedBy = "users")
  private List<Project> projects;

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Comment> comments;

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Issue> issues;

  @JsonIgnore
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
