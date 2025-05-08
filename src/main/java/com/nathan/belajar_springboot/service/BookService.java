package com.nathan.belajar_springboot.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathan.belajar_springboot.model.Author;
import com.nathan.belajar_springboot.model.Book;
import com.nathan.belajar_springboot.model.Publisher;
import com.nathan.belajar_springboot.repository.AuthorRepository;
import com.nathan.belajar_springboot.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void createNewBook() {

        Author author = new Author();
        author.setDescription("buku baru");
        author.setName("Tedy");

        Set<Author> authors = new HashSet<>();
        authors.add(author);

        Book book = new Book();
        book.setTitle("Kudeta Militer");
        book.setAuthors(authors);

        Publisher publisher = new Publisher();
        publisher.setTitle("Gramedia");
        publisher.setBooks(List.of(book));
        publisher.setDeleted(false);

        book.setPublisher(publisher);
        bookRepository.save(book);
    }

    public void updateBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        Author author = authorRepository.findById(1L).orElseThrow();

        Set<Author> authors = new HashSet<>();
        authors.add(author);

        book.setAuthors(authors);
        book.addAuthor(author);
        bookRepository.save(book);
    }
}
