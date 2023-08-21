package com.jirademo.jiraapi.issue;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Integer> {

  List<Issue> findByProjectId(Integer id);
}
