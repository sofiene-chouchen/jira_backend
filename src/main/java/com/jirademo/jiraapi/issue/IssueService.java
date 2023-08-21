package com.jirademo.jiraapi.issue;

import com.jirademo.jiraapi.project.Project;
import com.jirademo.jiraapi.project.ProjectRepository;
import com.jirademo.jiraapi.user.User;
import com.jirademo.jiraapi.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {
  private final IssueRepository repository;
  private final UserRepository userRepository;

  private final ProjectRepository projectRepository;

  public IssueService(IssueRepository repository, ProjectRepository projectRepository, UserRepository userRepository, ModelMapper modelMapper) {
    this.repository = repository;
    this.userRepository = userRepository;
    this.projectRepository = projectRepository;
  }

  public ResponseEntity<Issue> createIssue(IssueRequest issueRequest) {
    User user = userRepository.findById(issueRequest.getUser()).orElseThrow(() -> new RuntimeException("user not found"));
    Project project = projectRepository.findById(issueRequest.getProject()).orElseThrow(() -> new RuntimeException("project not found"));
    Issue Addissue = Issue.builder()
            .title(issueRequest.getTitle())
            .type(issueRequest.getType())
            .createdAt(LocalDateTime.now())
            .description(issueRequest.getDescription())
            .descriptionText(issueRequest.getDescriptionText())
            .estimate(issueRequest.getEstimate())
            .listPosition(issueRequest.getListPosition())
            .priority(issueRequest.getPriority())
            .type(issueRequest.getType())
            .reporterId(issueRequest.getReporterId())
            .timeRemaining(issueRequest.getTimeRemaining())
            .timeSpent(issueRequest.getTimeSpent())
            .user(user)
            .project(project)
            .build();
    return ResponseEntity.ok(repository.save(Addissue));
  }

  public List<Issue> getIssue() {
    return repository.findAll();
  }


}
