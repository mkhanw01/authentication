package com.waseem.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.waseem.auth"})
@EnableAutoConfiguration
@EnableAsync
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
    basePackages = {"com.waseem.auth.repository"})
@EnableJpaAuditing
@EntityScan(basePackages = {"com.waseem.auth.model"})
public class AuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthApplication.class, args);
  }
}
