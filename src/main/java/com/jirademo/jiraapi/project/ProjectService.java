package com.jirademo.jiraapi.project;

import com.jirademo.jiraapi.user.User;
import com.jirademo.jiraapi.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectService {
  private final ProjectRepository repository;

  private final UserRepository userRepository;

  public ProjectService(ProjectRepository repository, UserRepository userRepository) {
    this.repository = repository;
    this.userRepository = userRepository;
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


  public void AddUser(RequestAddUser response) {
    Project project = repository.findById(response.getProjectId()).orElseThrow(() -> new RuntimeException("project not find"));
    User user = userRepository.findById(response.getUserId()).orElseThrow(() -> new RuntimeException("user not found"));
    project.getUsers().add(user);
     repository.save(project);
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
