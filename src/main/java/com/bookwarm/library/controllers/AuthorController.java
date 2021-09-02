package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.Author;
import com.bookwarm.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Iterable<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping(params = { "page", "size" })
    public List<Author> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
        return authorService.findPaginated(page, size);
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

    @PostMapping("/bulkDelete")
    public void deleteAll(@RequestBody List<Long> ids) {
        authorService.deleteAll(ids);
    }

    @PutMapping("/{id}")
    public Author update(@RequestBody Author author, @PathVariable long id) {
        return authorService.update(author, id);
    }
}

