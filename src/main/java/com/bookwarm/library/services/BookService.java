package com.bookwarm.library.services;

import com.bookwarm.library.persistence.model.Author;
import com.bookwarm.library.persistence.model.Book;
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