package com.nathan.belajar_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathan.belajar_springboot.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
