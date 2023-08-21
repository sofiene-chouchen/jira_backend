package com.jirademo.jiraapi.issue;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


  @GetMapping("")
  public ResponseEntity<List<Issue>> getIssues() {
    return ResponseEntity.ok(service.getIssue());
  }
}
