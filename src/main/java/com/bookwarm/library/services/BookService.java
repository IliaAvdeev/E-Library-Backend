package com.bookwarm.library.services;

import com.bookwarm.library.persistence.model.*;
import com.bookwarm.library.persistence.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> findByCycle(Cycle cycle) {
        return bookRepository.findByCycle(cycle);
    }

    public Book findOne(long id) {
        return bookRepository.findById(id)
                .orElse(null);
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public void delete(long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
    }

    public Book updateBook(Book book, long id) {
        if ((book.getId() == id) && (bookRepository.existsById(id))){
            return bookRepository.save(book);
        } return null;
    }
}
