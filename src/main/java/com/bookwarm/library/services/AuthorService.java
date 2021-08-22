package com.bookwarm.library.services;

import com.bookwarm.library.persistence.model.Author;
import com.bookwarm.library.persistence.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> findByName(String authorName) {
        return authorRepository.findByName(authorName);
    }

    public Author findOne(long id) {
        return authorRepository.findById(id)
                .orElse(null);
    }

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public void delete(long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        }
    }

    public Author updateAuthor(Author author, long id) {
        if ((author.getId() == id) && (authorRepository.existsById(id))){
            return authorRepository.save(author);
        } return null;
    }
}