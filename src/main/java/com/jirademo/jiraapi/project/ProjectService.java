package com.jirademo.jiraapi.project;

import com.jirademo.jiraapi.user.User;
import com.jirademo.jiraapi.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
  private final ProjectRepository repository;

  private final UserRepository userRepository;

  public ProjectService(ProjectRepository repository, UserRepository userRepository) {
    this.repository = repository;
    this.userRepository = userRepository;
  }

  public Project createProject(ProjectDto projectDto) {

    List<User> associatedUsers = new ArrayList<>();

    for (Integer id : projectDto.getUsersId()) {
      Optional<User> userOptional = userRepository.findById(id);

      if (userOptional.isPresent()) {
        User user = userOptional.get();
        associatedUsers.add(user);
      } else {
      }
    }
    Project newProject = Project.builder()
            .name(projectDto.getName())
            .category(projectDto.getCategory())
            .createdAt(LocalDateTime.now())
            .description(projectDto.getDescription())
            .users(associatedUsers)
            .build();
    return repository.save(newProject);
  }

  public void updateProject(Integer id, Project project) {
    Project projectUpdate = repository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    projectUpdate.setCategory(project.getCategory());
    repository.save(projectUpdate);
  }


  public void AddUser(RequestAddUser response) {
    Project project = repository.findById(response.getProjectId()).orElseThrow(() -> new RuntimeException("project not find"));
    User user = userRepository.findById(response.getUserId()).orElseThrow(() -> new RuntimeException("user not found"));
    project.getUsers().add(user);
    repository.save(project);
  }

  public Optional<Project> getProjectById(Integer id) {
    return repository.findById(id);
  }

  public Project getPrijectByUser(Integer userId) {
    User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
    return repository.findByUsers(user);
  }

  public List<Project> getProject() {

    return repository.findAll();
  }

  public void deleteltById(Integer id) {
    repository.deleteById(id);
  }
}
