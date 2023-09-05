package com.jirademo.jiraapi.project;

import com.jirademo.jiraapi.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project , Integer> {
Project findByUsers(User user);
}
