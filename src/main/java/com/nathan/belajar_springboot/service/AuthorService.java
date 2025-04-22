package com.nathan.belajar_springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nathan.belajar_springboot.dto.AuthorDto;
import com.nathan.belajar_springboot.model.Author;

@Service
public class AuthorService {

    private List<Author> authors = new ArrayList<>();

    public void createAuthor(AuthorDto authorDto) {
        Author author = new Author(String.valueOf(authors.size() + 1), authorDto.name(), authorDto.description());
        authors.add(author);
    }

    public List<Author> getList() {
        return authors;
    }

    public Author getByIndex(int index) {
        return authors.get(index);
    }
}
