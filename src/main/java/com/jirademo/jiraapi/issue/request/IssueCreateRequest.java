package com.jirademo.jiraapi.issue.request;

import com.jirademo.jiraapi.issue.Issue;
import lombok.Data;

@Data
public class IssueCreateRequest {
  private Integer projectId;
  private Integer userId;
  private Issue issue;
}
