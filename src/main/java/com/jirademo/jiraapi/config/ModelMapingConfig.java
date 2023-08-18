package com.jirademo.jiraapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ModelMapingConfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
