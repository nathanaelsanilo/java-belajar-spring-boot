package com.nathan.belajar_springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nathan.belajar_springboot.dto.AuthorDto;
import com.nathan.belajar_springboot.model.Author;
import com.nathan.belajar_springboot.service.AuthorService;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("new")
    public String createAuthor(Model model) {
        model.addAttribute("authorDto", new AuthorDto("", ""));
        return "author/create-author";
    }

    @GetMapping("result/{index}")
    public String resultAuthor(Model model, @PathVariable int index) {
        Author author = authorService.getByIndex(index);
        model.addAttribute("author", author);
        return "author/author-result";
    }

    @GetMapping("list")
    public String listAuthor(Model model) {
        List<Author> authors = authorService.getList();
        model.addAttribute("authors", authors);
        return "author/author-list";
    }

    @PostMapping("new")
    public String submitForm(@ModelAttribute AuthorDto authorDto, RedirectAttributes redirectAttributes) {
        authorService.createAuthor(authorDto);
        return "redirect:/author/list";
    }
}
