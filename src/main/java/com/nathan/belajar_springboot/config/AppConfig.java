package com.nathan.belajar_springboot.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

@ComponentScan(basePackages = "com.nathan")
@Configuration
public class AppConfig {
    @Bean
    public PasswordAuthentication passwordAuthentication() {
        return new PasswordAuthentication("kali.jones78@ethereal.email", "4huzpN44KmXWXGUt2y");
    }

    @Bean
    public Properties properties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.ethereal.email");
        prop.put("mail.smtp.port", "587");
        return prop;
    }

    @Bean
    public Session mailSession(@Qualifier("properties") Properties configProperties,
            PasswordAuthentication passwordAuthentication) {
        return Session.getInstance(configProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return passwordAuthentication;
            }
        });
    }
}
