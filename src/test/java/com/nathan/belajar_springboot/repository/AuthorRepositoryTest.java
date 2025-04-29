package com.nathan.belajar_springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nathan.belajar_springboot.model.Author;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void testSaveAuthor() {
        Author author = new Author();
        author.setName("jaka");
        author.setDescription("penulis pemula");
        authorRepository.save(author);
    }

    @Test
    void testFindAuthorByName() {
        Author author = new Author();
        author.setName("jaka");
        author.setDescription("penulis pemula");
        authorRepository.save(author);

        List<Author> authors = authorRepository.findByNameLikeIgnoreCase("jaka");
        assertEquals(1, authors.size());
    }
}
