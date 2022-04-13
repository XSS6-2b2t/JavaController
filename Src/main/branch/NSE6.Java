package com.GetForkedNerd.2bGroup.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.GetForkedNerd.2bGroup.server.properties")
public class GroupApplication {
  public static void main(String[] args) {
    SpringApplication.run(GroupApplication.class, args);
  }
}
