package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.Book;
import com.bookwarm.library.persistence.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // equivalent to a @Controller along with @ResponseBody (@ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object)
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable long id) {
        return bookRepository.findById(id)
                .orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {  // @RequestBody annotation must correspond to the JSON sent from our client-side controller
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        }
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable long id) {
        if ((book.getId() == id) && (bookRepository.findById(id).isPresent())) {
            return bookRepository.save(book);
        } return null;
    }
}
