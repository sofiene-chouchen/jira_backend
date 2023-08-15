package com.jirademo.jiraapi.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project , Integer> {
}
