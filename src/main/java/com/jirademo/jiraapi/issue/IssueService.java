package com.jirademo.jiraapi.issue;

import com.jirademo.jiraapi.project.Project;
import com.jirademo.jiraapi.project.ProjectRepository;
import com.jirademo.jiraapi.user.User;
import com.jirademo.jiraapi.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IssueService {
  private ProjectRepository projectRepository;
  private final IssueRepository repository;

  private final UserRepository userRepository;

  public IssueService(IssueRepository repository, ProjectRepository projectRepository, UserRepository userRepository) {
    this.projectRepository = projectRepository;
    this.repository = repository;
    this.userRepository = userRepository;
  }

  public ResponseEntity<Issue> createIssue(Issue issue, Integer projectId) {
    Project projects = projectRepository.findById(projectId).orElseThrow(() -> new EntityNotFoundException("Project not found"));
    //User users = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
    Issue Addissue = Issue.builder()
            .title(issue.getTitle())
            .type(issue.getType())
            .comments(issue.getComments())
            .createdAt(LocalDateTime.now())
            .description(issue.getDescription())
            .descriptionText(issue.getDescriptionText())
            .estimate(issue.getEstimate())
            .listPosition(issue.getListPosition())
            .priority(issue.getPriority())
            .type(issue.getType())
            .reporterId(issue.getReporterId())
            .timeRemaining(issue.getTimeRemaining())
            .timeSpent(issue.getTimeSpent())
            .project(projects)
            .build();
    return ResponseEntity.ok(repository.save(Addissue));
  }

}
