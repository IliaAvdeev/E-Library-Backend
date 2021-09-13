package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.Genre;
import com.bookwarm.library.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public Iterable<Genre> findAll() {
        return genreService.findAll();
    }

    @GetMapping(value = "/genres", params = {"page", "size"})
    public List<Genre> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
        return genreService.findPaginated(page, size);
    }

    @GetMapping("/genres/{id}")
    public Genre findOne(@PathVariable long id) {
        return genreService.findOne(id);
    }

    @PostMapping("/admin/genres/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Genre create(@RequestBody Genre genre) {
        return genreService.create(genre);
    }

    @DeleteMapping("/admin/genres/delete/{id}")
    public void delete(@PathVariable long id) {
        genreService.delete(id);
    }

    @PostMapping("/admin/genres/delete/multiple")
    public void deleteAll(@RequestBody List<Long> ids) {
        genreService.deleteAll(ids);
    }

    @PutMapping("/admin/genres/update/{id}")
    public Genre update(@RequestBody Genre genre, @PathVariable long id) {
        return genreService.update(genre, id);
    }
}

