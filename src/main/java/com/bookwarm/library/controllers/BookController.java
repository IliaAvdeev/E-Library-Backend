package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.Book;
import com.bookwarm.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping(value = "/books", params = {"page", "size"})
    public List<Book> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
        return bookService.findPaginated(page, size);
    }

    @GetMapping("/books/author/{authorId}")
    public List<Book> findByAuthorId(@PathVariable long authorId) {
        return bookService.findByAuthorId(authorId);
    }

    @GetMapping("/books/genre/{genreId}")
    public List<Book> findByGenreId(@PathVariable long genreId) {
        return bookService.findByGenreId(genreId);
    }

    @GetMapping("/books/cycle/{cycleId}")
    public List<Book> findByCycleId(@PathVariable long cycleId) {
        return bookService.findByCycleId(cycleId);
    }

    @GetMapping("/books/{id}")
    public Book findOne(@PathVariable long id) {
        return bookService.findOne(id);
    }

    @PostMapping("/admin/books/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @DeleteMapping("/admin/books/delete/{id}")
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }

    @PostMapping("/admin/books/delete/multiple")
    public void deleteAll(@RequestBody List<Long> ids) {
        bookService.deleteAll(ids);
    }

    @PutMapping("/admin/books/update/{id}")
    public Book update(@RequestBody Book book, @PathVariable long id) {
        return bookService.update(book, id);
    }
}