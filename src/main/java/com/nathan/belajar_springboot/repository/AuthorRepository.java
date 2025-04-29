package com.nathan.belajar_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathan.belajar_springboot.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public List<Author> findByNameLikeIgnoreCase(String name);
}
