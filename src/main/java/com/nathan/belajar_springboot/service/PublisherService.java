package com.nathan.belajar_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathan.belajar_springboot.model.Publisher;
import com.nathan.belajar_springboot.repository.PublisherRepository;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public void deletePublisher(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow();
        publisher.setDeleted(true);
        publisherRepository.save(publisher);
    }
}
