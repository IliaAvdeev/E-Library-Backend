package com.bookwarm.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan()
@SpringBootApplication(scanBasePackages = "com.bookwarm")  // equivalent to @Configuration, @EnableAutoConfiguration, and @ComponentScan together
@EnableJpaRepositories("com.bookwarm.library.persistence.repositories")  // scan the specified package for repositories
@EntityScan("com.bookwarm.library.persistence.model")  // pick up our JPA entities
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
