package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.Author;
import com.bookwarm.library.persistence.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // equivalent to a @Controller along with @ResponseBody
@RequestMapping("/authors")
public class AuthorController {
    @Autowired   // allows Spring to resolve and inject collaborating beans into our bean
    private AuthorRepository authorRepository;

    @GetMapping
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @GetMapping("/name/{authorName}")
    public List<Author> findByName(@PathVariable String authorName) {
        return authorRepository.findByName(authorName);
    }

    @GetMapping("/{id}")
    public Author findOne(@PathVariable long id) {
        return authorRepository.findById(id)
                .orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        if (authorRepository.findById(id).isPresent()) {
            authorRepository.deleteById(id);
        }
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable long id) {
        if ((author.getId() == id) && (authorRepository.findById(id).isPresent())) {
            return authorRepository.save(author);
        } return null;
    }
}

