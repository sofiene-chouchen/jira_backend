package com.jirademo.jiraapi.issue;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/issues")
public class IssueController {
  private final IssueService service;

  public IssueController(IssueService service) {
    this.service = service;
  }

  @PostMapping("/addIssue")
  public ResponseEntity<?> createIssue(@RequestBody IssueRequest issue) {
    return ResponseEntity.ok(service.createIssue(issue));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Issue>> getIssueById(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getbyId(id));
  }

  @GetMapping("")
  public ResponseEntity<List<Issue>> getIssues() {
    return ResponseEntity.ok(service.getIssue());
  }

  @GetMapping("/project/{id}")
  public ResponseEntity<List<Issue>> getByProject(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getIssueByProject(id));
  }

  @PutMapping("/{id}")
  public void updateIsssue(@PathVariable Integer id, @RequestBody Issue issue) {
    service.UpdateIsuue(id, issue);
  }

  @DeleteMapping("")
  public void IssueDelete() {
    service.IssueDelete();
  }
}
