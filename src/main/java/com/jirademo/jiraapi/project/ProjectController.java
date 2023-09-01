package com.jirademo.jiraapi.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/project")
@CrossOrigin
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

  @GetMapping("/user/{id}")
  public ResponseEntity<Project> getProjectByUserId(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getPrijectByUser(id));
  }

  @PutMapping("")
  public void addUser(@RequestBody RequestAddUser requestAddUser) {
    service.AddUser(requestAddUser);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Project>> getProjectById(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getProjectById(id));
  }

  @PatchMapping("/{id}")
  public void updateProject(@PathVariable Integer id, @RequestBody Project project) {
    service.updateProject(id, project);
  }

}



