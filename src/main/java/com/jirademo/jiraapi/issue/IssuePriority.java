package com.jirademo.jiraapi.issue;

public enum IssuePriority {
  HIGHEST(5),
  HIGH(4),
  MEDIUM(3),
  LOW(2),
  LOWEST(1);
  final int value;

  IssuePriority(int level) {
    this.value = level;
  }
}
