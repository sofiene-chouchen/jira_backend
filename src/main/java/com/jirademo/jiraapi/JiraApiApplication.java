package com.jirademo.jiraapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class JiraApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(JiraApiApplication.class, args);
  }

//  @Bean
//  public WebMvcAutoConfiguration configuration() {
//    return new WebMvcAutoConfiguration() {
//
//      public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("*");
//      }
//    };
//  }


}
