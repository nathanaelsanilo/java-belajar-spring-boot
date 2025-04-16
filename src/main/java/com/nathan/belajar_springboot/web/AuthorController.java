package com.nathan.belajar_springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nathan.belajar_springboot.dto.AuthorDto;
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

    @GetMapping("result")
    public String resultAuthor(Model model) {
        // List<String> authorNames = authorService.getAuthorNames();
        // AuthorDto authorDto = new AuthorDto(authorNames.get(0));
        // model.addAttribute("authorDto", authorDto);
        return "author/author-result";
    }

    @PostMapping("new")
    public String submitForm(@ModelAttribute AuthorDto authorDto, RedirectAttributes redirectAttributes) {
        System.out.println(authorDto);
        // authorService.createAuthor(authorDto);
        redirectAttributes.addFlashAttribute("authorDto", authorDto);
        return "redirect:/author/result";
    }
}
