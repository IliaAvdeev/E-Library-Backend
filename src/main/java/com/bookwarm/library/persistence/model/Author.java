package com.bookwarm.library.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

    @Column(name = "country_of_birth")
    private String countryOfBirth;

    @Column(name = "country_of_death")
    private String countryOfDeath;

    private String biography;

    public Author() {
        super();
    }

    public Author(long id, String name, Date dateOfBirth, Date dateOfDeath, String countryOfBirth, String countryOfDeath, String biography) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.countryOfBirth = countryOfBirth;
        this.countryOfDeath = countryOfDeath;
        this.biography = biography;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getCountryOfDeath() {
        return countryOfDeath;
    }

    public void setCountryOfDeath(String countryOfDeath) {
        this.countryOfDeath = countryOfDeath;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", countryOfDeath='" + countryOfDeath + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
