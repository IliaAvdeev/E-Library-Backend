package com.bookwarm.library.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Column(name = "author_id")
    private long authorId;

    @Column(name = "genre_id")
    private long genreId;

    @Column(name = "cycle_id")
    private long cycleId;

    private String description;
    private String text;

    public Book() {
        super();
    }

    public Book(String title, long authorId, long genreId, long cycleId, String description, String text) {
        super();
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
        this.cycleId = cycleId;
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

    public long getAuthor() {
        return authorId;
    }

    public void setAuthor(long authorId) {
        this.authorId = authorId;
    }

    public long getGenre() {
        return genreId;
    }

    public void setGenre(long genreId) {
        this.genreId = genreId;
    }

    public long getCycle() {
        return cycleId;
    }

    public void setCycle(long cycleId) {
        this.cycleId = cycleId;
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
