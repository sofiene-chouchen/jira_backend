package com.jirademo.jiraapi.comment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

  private final CommentService service;


  public CommentController(CommentService service) {
    this.service = service;
  }

  @PostMapping("")
  public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
    return ResponseEntity.ok(service.createComment(comment).getBody());
  }

}
