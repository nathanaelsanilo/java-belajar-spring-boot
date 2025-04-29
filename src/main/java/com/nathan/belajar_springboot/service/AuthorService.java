package com.nathan.belajar_springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nathan.belajar_springboot.dto.AuthorDto;
import com.nathan.belajar_springboot.dto.ResultPageResponseDto;
import com.nathan.belajar_springboot.model.Author;
import com.nathan.belajar_springboot.repository.AuthorRepository;
import com.nathan.belajar_springboot.util.PaginationUtil;

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

    public ResultPageResponseDto<AuthorDto> findAuthors(
            int page,
            int limit,
            String sortBy,
            String direction,
            String authorName) {
        Direction sortDirection = PaginationUtil.getSortDirection(direction);

        authorName = StringUtils.hasText(authorName) ? authorName + "%" : "%";

        Pageable pageable = PageRequest.of(
                page,
                limit,
                Sort.by(new Sort.Order(sortDirection, sortBy)));
        Page<Author> authors = authorRepository.findByNameLikeIgnoreCase(authorName, pageable);

        List<AuthorDto> list = new ArrayList<AuthorDto>();
        for (Author author : authors) {
            AuthorDto dto = new AuthorDto(author.getName(), author.getDescription());
            list.add(dto);
        }

        ResultPageResponseDto<AuthorDto> response = new ResultPageResponseDto<>(list, page, authors.getTotalElements());
        return response;
    }
}
