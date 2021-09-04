package com.bookwarm.library.services;

import com.bookwarm.library.persistence.model.Book;
import com.bookwarm.library.persistence.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findPaginated(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size)).toList();
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findByAuthorId(long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public List<Book> findByGenreId(long genreId) {
        return bookRepository.findByGenreId(genreId);
    }

    public List<Book> findByCycleId(long cycleId) {
        return bookRepository.findByCycleId(cycleId);
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

    public void deleteAll(List<Long> ids) {
        if (ids.stream().allMatch(id -> bookRepository.existsById(id))) {
            bookRepository.deleteAllById(ids);
        }
    }

    public Book updateBook(Book book, long id) {
        if ((book.getId() == id) && (bookRepository.existsById(id))){
            return bookRepository.save(book);
        } return null;
    }
}
