package com.jirademo.jiraapi.comment;

import com.jirademo.jiraapi.issue.Issue;
import com.jirademo.jiraapi.issue.IssueRepository;
import com.jirademo.jiraapi.user.User;
import com.jirademo.jiraapi.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

  private final CommentRepository repository;
  private final IssueRepository issueRepository;

  private final UserRepository userRepository;

  public CommentService(CommentRepository repository, IssueRepository issueRepository, UserRepository userRepository) {
    this.repository = repository;
    this.issueRepository = issueRepository;
    this.userRepository = userRepository;
  }

  public ResponseEntity<Comment> createComment(CommentRequest comment) {
    User user = userRepository.findById(comment.getUser()).orElseThrow(() -> new RuntimeException("user not found"));
    Issue issue = issueRepository.findById(comment.getIssues()).orElseThrow(() -> new RuntimeException("issue not found"));
    Comment newComment = Comment.builder()
            .body(comment.getBody())
            .issues(issue)
            .user(user)
            .createdAt(LocalDateTime.now())
            .build();
    return ResponseEntity.ok(repository.save(newComment));
  }

  public ResponseEntity<List<Comment>> getComment() {
    return ResponseEntity.ok(repository.findAll());
  }

  public List<Comment> getByIssue(Integer id) {
    return repository.findByIssuesId(id);
  }

}
