package com.jirademo.jiraapi.project;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectService {
  private final ProjectRepository repository;

  public ProjectService(ProjectRepository repository) {
    this.repository = repository;
  }

  public Project createProject(Project project) {
    Project newProject = Project.builder()
            .name(project.getName())
            .category(project.getCategory())
            .createdAt(LocalDateTime.now())
            .description(project.getDescription())
            .build();
    return repository.save(newProject);
  }

  /*public void addUserToProject(Integer projectId, Integer userId) {
    Project project = repository.findById(projectId)
           .orElseThrow(() -> new EntityNotFoundException("Project not found"));

    User user = repository.findById(userId)
     .orElseThrow(() -> new EntityNotFoundException("User not found"));

    project.getUsers().add(user);
    repository.save(project);
  }*/

  public List<Project> getProject (){
    return repository.findAll();

  }
}
