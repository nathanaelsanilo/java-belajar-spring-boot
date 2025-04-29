package com.nathan.belajar_springboot.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // optional
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
