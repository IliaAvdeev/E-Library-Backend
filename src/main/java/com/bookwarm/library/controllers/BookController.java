package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.*;
import com.bookwarm.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookService.findByTitle(bookTitle);
    }

    @GetMapping("/author/{authorName}")
    public List<Book> findByAuthor(Author author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/genre/{genreName}")
    public List<Book> findByGenre(Genre genre) {
        return bookService.findByGenre(genre);
    }

    @GetMapping("/cycle/{cycleName}")
    public List<Book> findByCycle(Cycle cycle) {
        return bookService.findByCycle(cycle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable long id) {
        return bookService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable long id) {
        return bookService.updateBook(book, id);
    }
}