package com.jirademo.jiraapi.issue;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/issue")
public class IssueController {
  private final IssueService service;

  public IssueController(IssueService service) {
    this.service = service;
  }

  @PostMapping("/addIssue")
  public ResponseEntity<?> createIssue(@RequestBody IssueRequest issue) {
    return ResponseEntity.ok(service.createIssue(issue).getBody());
  }
}
