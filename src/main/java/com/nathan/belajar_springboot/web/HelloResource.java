package com.nathan.belajar_springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.belajar_springboot.config.ApplicationProperties;

@RestController
@RequestMapping("v1/hello")
public class HelloResource {

    private ApplicationProperties applicationProperties;

    public HelloResource(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @GetMapping
    public String hello() {
        return applicationProperties.getEmailUser() + " : " + applicationProperties.getEmailSmtp() + " : "
                + applicationProperties.getEmailPassword();
    }
}
