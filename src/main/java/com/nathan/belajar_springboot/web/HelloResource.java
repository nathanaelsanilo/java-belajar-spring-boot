package com.nathan.belajar_springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.nathan.belajar_springboot.config.ApplicationProperties;

@Controller
@RequestMapping("v1/hello")
public class HelloResource {

    private ApplicationProperties applicationProperties;

    public HelloResource(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("name", "model nathan");
        return "hello";
        // return applicationProperties.getEmailUser() + " : " +
        // applicationProperties.getEmailSmtp() + " : "
        // + applicationProperties.getEmailPassword();
    }
}
