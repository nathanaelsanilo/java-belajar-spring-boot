package com.nathan.belajar_springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathan.belajar_springboot.dto.AuthorDto;
import com.nathan.belajar_springboot.model.Author;
import com.nathan.belajar_springboot.repository.AuthorRepository;

@Service
public class AuthorService {

    private List<Author> authors = new ArrayList<>();

    @Autowired
    AuthorRepository authorRepository;

    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setDescription(authorDto.description());
        author.setName(authorDto.name());
        authorRepository.save(author);
        return authorDto;
    }

    public List<Author> getList() {
        return authorRepository.findAll();
    }

    public Author getByIndex(int index) {
        return authors.get(index);
    }

    public List<AuthorDto> getByName(String name) {
        name = name + "%";
        List<Author> authors = authorRepository.findByNameLikeIgnoreCase(name);
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : authors) {
            AuthorDto authorDto = new AuthorDto(
                    author.getName(),
                    author.getDescription());
            authorDtos.add(authorDto);
        }
        return authorDtos;
    }
}
