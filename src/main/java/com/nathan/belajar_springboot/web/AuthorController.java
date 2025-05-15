package com.nathan.belajar_springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nathan.belajar_springboot.dto.AuthorDto;
import com.nathan.belajar_springboot.dto.ResultPageResponseDto;
import com.nathan.belajar_springboot.model.Author;
import com.nathan.belajar_springboot.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping()
    public AuthorDto createAuthor(@RequestBody @Valid AuthorDto authorDto) {
        return authorService.createAuthor(authorDto);
    }

    @GetMapping("result/{index}")
    public String resultAuthor(Model model, @PathVariable int index) {
        Author author = authorService.getByIndex(index);
        model.addAttribute("author", author);
        return "author/author-result";
    }

    @GetMapping()
    public ResultPageResponseDto<AuthorDto> listAuthor(
            @RequestParam(name = "name", required = false) String authorName,
            @RequestParam(name = "sortBy", defaultValue = "name", required = false) String sortBy,
            @RequestParam(name = "dir", defaultValue = "asc", required = false) String sortDir,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "limit", defaultValue = "10", required = false) int limit) {
        // return authorService.getByName(name);
        return authorService.findAuthors(page, limit, sortBy, sortDir, authorName);
    }

    @PostMapping("new")
    public String submitForm(@ModelAttribute AuthorDto authorDto, RedirectAttributes redirectAttributes) {
        authorService.createAuthor(authorDto);
        return "redirect:/author/list";
    }
}
