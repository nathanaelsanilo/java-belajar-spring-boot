package com.nathan.belajar_springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nathan.belajar_springboot.dto.AuthorDto;

@Service
public class AuthorService {

    private List<String> authorNames = new ArrayList<>();

    public void createAuthor(AuthorDto authorDto) {
        authorNames.add(authorDto.name());
    }

    public List<String> getAuthorNames() {
        return authorNames;
    }

    public String getByIndex(int index) {
        return authorNames.get(index);
    }
}
