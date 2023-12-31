package com.jirademo.jiraapi.comment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@CrossOrigin
public class CommentController {

  private final CommentService service;


  public CommentController(CommentService service) {
    this.service = service;
  }

  @PostMapping("")
  public ResponseEntity<Comment> createComment(@RequestBody CommentRequest comment) {
    return ResponseEntity.ok(service.createComment(comment).getBody());
  }

  @GetMapping("")
  public ResponseEntity<?> getComment() {
    return ResponseEntity.ok(service.getComment());

  }

  @GetMapping("/{id}")
  public ResponseEntity<List<Comment>> findbyIssue(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getByIssue(id));
  }

  @DeleteMapping("")
  public void deleteComments() {
    service.deleteComment();
  }
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Integer id){
    service.deletCommentById(id);
  }
  @PutMapping("/{id}")
  public void updateComment(@PathVariable Integer id , @RequestBody Comment comment){
    service.updateComment(id , comment);
  }

}
