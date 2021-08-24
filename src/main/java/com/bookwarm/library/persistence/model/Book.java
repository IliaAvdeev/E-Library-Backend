package com.bookwarm.library.persistence.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Author author;

    @Column(nullable = false)
    private Genre genre;

    @Column
    private Cycle cycle;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String text;

    public Book() {
        super();
    }

    public Book(String title, Author author, Genre genre, Cycle cycle, String description, String text) {
        super();
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cycle = cycle;
        this.description = description;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
