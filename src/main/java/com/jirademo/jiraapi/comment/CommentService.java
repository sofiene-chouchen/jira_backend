package com.jirademo.jiraapi.comment;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

  private final CommentRepository repository;

  public CommentService(CommentRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<Comment> createComment(Comment comment) {
    Comment newComment = Comment.builder()
            .body(comment.getBody())
            .issues(comment.getIssues())
            .user(comment.getUser())
            .createdAt(LocalDateTime.now())
            .build();
    return ResponseEntity.ok(repository.save(newComment));
  }
}
