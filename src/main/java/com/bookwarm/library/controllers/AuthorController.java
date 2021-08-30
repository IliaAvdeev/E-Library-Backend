package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.Author;
import com.bookwarm.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Iterable<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/name/{authorName}")
    public List<Author> findByName(@PathVariable String authorName) {
        return authorService.findByName(authorName);
    }

    @GetMapping("/{id}")
    public Author findOne(@PathVariable long id) {
        return authorService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return authorService.create(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        authorService.delete(id);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable long id) {
        return authorService.updateAuthor(author, id);
    }
}

