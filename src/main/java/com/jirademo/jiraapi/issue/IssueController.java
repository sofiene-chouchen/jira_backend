package com.jirademo.jiraapi.issue;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/issue")
public class IssueController {
  private final IssueService service;

  public IssueController(IssueService service) {
    this.service = service;
  }

  @PostMapping("")
  public ResponseEntity<Issue> createIssue(@RequestBody Issue issue) {
    return ResponseEntity.ok(service.createIssue(issue).getBody());
  }
}
