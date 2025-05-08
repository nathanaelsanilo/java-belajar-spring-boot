package com.nathan.belajar_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathan.belajar_springboot.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    public Publisher findByIdAndDeletedIsFalse(Long id);
}
