package com.jirademo.jiraapi.issue;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IssuePriority {
  LOWEST("0"),
  LOW("1"),
  MEDIUM("2"),
  HIGH("3"),
  HIGHEST("4");
  private final String value;

  IssuePriority(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }
}
