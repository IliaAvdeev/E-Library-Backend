package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.Genre;
import com.bookwarm.library.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@CrossOrigin(origins = "http://localhost:4200")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    public Iterable<Genre> findAll() {
        return genreService.findAll();
    }

    @GetMapping("/name/{genreName}")
    public List<Genre> findByName(@PathVariable String genreName) {
        return genreService.findByName(genreName);
    }

    @GetMapping("/{id}")
    public Genre findOne(@PathVariable long id) {
        return genreService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genre create(@RequestBody Genre genre) {
        return genreService.create(genre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        genreService.delete(id);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@RequestBody Genre genre, @PathVariable long id) {
        return genreService.updateGenre(genre, id);
    }
}

