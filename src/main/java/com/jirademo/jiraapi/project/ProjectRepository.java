package com.jirademo.jiraapi.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project , Integer> {

}
