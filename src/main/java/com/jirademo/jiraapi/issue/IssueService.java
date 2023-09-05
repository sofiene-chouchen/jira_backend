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
import java.util.Optional;

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
    User user = null;
    if (issueRequest.getUser() != null) {
      user = userRepository.findById(issueRequest.getUser()).orElseThrow(() -> new RuntimeException("user not found"));
    }
    Project project = projectRepository.findById(issueRequest.getProject()).orElseThrow(() -> new RuntimeException("project not found"));
    Issue Addissue = Issue.builder()
            .title(issueRequest.getTitle())
            .type(issueRequest.getType()).
            status(issueRequest.getStatus())
            .createdAt(LocalDateTime.now())
            .description(issueRequest.getDescription())
            .descriptionText(issueRequest.getDescriptionText()).
            estimate(issueRequest.getEstimate())
            .listPosition(issueRequest.getListPosition())
            .priority(issueRequest.getPriority()).
            type(issueRequest.getType()).
            reporterId(issueRequest.getReporterId())
            .timeRemaining(issueRequest.getTimeRemaining())
            .timeSpent(issueRequest.getTimeSpent())
            .user(user)
            .project(project).
            build();
    return ResponseEntity.ok(repository.save(Addissue));
  }

  public List<Issue> getIssue() {
    return repository.findAll();
  }

  public List<Issue> getIssueByProject(Integer id) {
    return repository.findByProjectId(id);
  }

  public Optional<Issue> getbyId(Integer id) {
    return repository.findById(id);
  }

  public void IssueDelete() {
    repository.deleteAll();
  }

  public void UpdateIsuue(Integer id, Issue issueRequest) {
    Issue issue = repository.findById(id).orElseThrow(() -> new RuntimeException("the issue not exist "));
    if (issueRequest.getPriority() == null) {
      issue.setPriority(issue.getPriority());
    } else {
      issue.setPriority(issueRequest.getPriority());
    }
    if (issueRequest.getListPosition() == null) {
      issue.setListPosition(issue.getListPosition());
    } else {
      issue.setListPosition(issueRequest.getListPosition());
    }
    if (issueRequest.getStatus() == null) {
      issue.setStatus(issue.getStatus());
    } else {
      issue.setStatus(issueRequest.getStatus());
    }
    if (issueRequest.getType() == null) {
      issue.setType(issue.getType());
    } else {
      issue.setType(issueRequest.getType());
    }
    if (issueRequest.getTimeRemaining() == null) {
      issue.setTimeRemaining(issue.getTimeRemaining());
    } else {
      issue.setTimeRemaining(issueRequest.getTimeRemaining());
    }
    if (issueRequest.getEstimate() == null) {
      issue.setEstimate(issue.getEstimate());
    } else {
      issue.setEstimate(issueRequest.getEstimate());
    }
    issue.setUpdatedAt(LocalDateTime.now());
    repository.save(issue);
  }



}
