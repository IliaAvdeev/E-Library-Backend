package com.bookwarm.library.services;

import com.bookwarm.library.persistence.model.Genre;
import com.bookwarm.library.persistence.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }

    public List<Genre> findByName(String genreName) {
        return genreRepository.findByName(genreName);
    }

    public Genre findOne(long id) {
        return genreRepository.findById(id)
                .orElse(null);
    }

    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    public void delete(long id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
        }
    }

    public Genre updateGenre(Genre genre, long id) {
        if ((genre.getId() == id) && (genreRepository.existsById(id))){
            return genreRepository.save(genre);
        } return null;
    }
}