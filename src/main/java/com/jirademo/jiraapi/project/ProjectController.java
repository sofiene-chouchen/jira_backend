package com.jirademo.jiraapi.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

  private ProjectService service;

  public ProjectController(ProjectService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<?> createProject(@RequestBody Project project) {
    return ResponseEntity.ok(service.createProject(project));

  }
/*  @PostMapping("/{projectId}/add-user/{userId}")
  public ResponseEntity<?> addUserToProject(
          @PathVariable Integer projectId,
          @PathVariable Integer userId
  ) {
    service.addUserToProject(projectId, userId);
    return ResponseEntity.ok("User added to the project.");
  }

 */
  @GetMapping
  public List<Project> getProjects (){
    return service.getProject();
  }
}
