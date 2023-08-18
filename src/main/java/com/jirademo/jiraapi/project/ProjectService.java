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

  public Project createProject(ProjectDto projectDto) {
    Project newProject = Project.builder()
            .name(projectDto.getName())
            .category(projectDto.getCategory())
            .createdAt(LocalDateTime.now())
            .description(projectDto.getDescription())
            .build();
    return repository.save(newProject);
  }


  public Project AddUser(Integer projectId , Project project){
    Project project1 = repository.findById(projectId).orElseThrow(() -> new RuntimeException("project dosnet exist "));
    project1 =Project.builder()
            .users(project.getUsers())
            .build();
    return repository.save(project1);
  }









  /*public void addUserToProject(Integer projectId, Integer userId) {
    Project project = repository.findById(projectId)
           .orElseThrow(() -> new EntityNotFoundException("Project not found"));

    User user = repository.findById(userId)
     .orElseThrow(() -> new EntityNotFoundException("User not found"));

    project.getUsers().add(user);
    repository.save(project);
  }*/

  public List<Project> getProject() {
    return repository.findAll();

  }
}
