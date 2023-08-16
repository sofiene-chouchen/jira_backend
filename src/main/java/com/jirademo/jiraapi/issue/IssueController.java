package com.jirademo.jiraapi.issue;


import com.jirademo.jiraapi.issue.request.IssueCreateRequest;
import com.jirademo.jiraapi.project.Project;
import com.jirademo.jiraapi.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/issue")
public class IssueController {
  private final IssueService service;

  public IssueController(IssueService service) {
    this.service = service;
  }

  @PostMapping("/{projectId}")
  public ResponseEntity<Issue> createIssue(@RequestBody Issue issue, @PathVariable Integer projectId) {
    return ResponseEntity.ok(service.createIssue(issue, projectId).getBody());
  }
}
