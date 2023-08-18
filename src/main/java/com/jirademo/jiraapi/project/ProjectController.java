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

  @PostMapping("/addProject")
  public ResponseEntity<Project> createProject(@RequestBody ProjectDto projectDto) {
    return ResponseEntity.ok(service.createProject(projectDto));
  }

  @GetMapping("")
  public List<Project> getProjects() {
    return service.getProject();
  }

  @PutMapping("/{projectId}")
  public ResponseEntity<Project> addUser(@PathVariable Integer projectId, @RequestBody Project project) {
    return ResponseEntity.ok(service.AddUser(projectId, project));
  }
}



