package com.bookwarm.library;

import com.bookwarm.library.persistence.model.Author;
import com.bookwarm.library.persistence.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.stream.Stream;

@ServletComponentScan()
@SpringBootApplication(scanBasePackages = "com.bookwarm")  // equivalent to @Configuration, @EnableAutoConfiguration, and @ComponentScan together
@EnableJpaRepositories("com.bookwarm.library.persistence.repositories")  // scan the specified package for repositories
@EntityScan("com.bookwarm.library.persistence.model")  // pick up our JPA entities
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(AuthorRepository authorRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                Author author = new Author(name, new Date(), null);
                authorRepository.save(author);
            });
        };
    }
}