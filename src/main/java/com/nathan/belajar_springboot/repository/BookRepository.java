package com.nathan.belajar_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathan.belajar_springboot.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
