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
        Author author = new Author();
        author.setDescription(authorDto.description());
        author.setName(authorDto.name());
        authors.add(author);
    }

    public List<Author> getList() {
        return authors;
    }

    public Author getByIndex(int index) {
        return authors.get(index);
    }
}
