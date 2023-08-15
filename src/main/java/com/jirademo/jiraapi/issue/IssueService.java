package com.jirademo.jiraapi.issue;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IssueService {

  private final IssueRepository repository;

  public IssueService(IssueRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<Issue> createIssue(Issue issue) {
    Issue Addissue = Issue.builder()
            .title(issue.getTitle())
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
            .user(issue.getUser())
            .project(issue.getProject())
            .build();
    return ResponseEntity.ok(repository.save(Addissue));
  }
}
