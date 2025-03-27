package com.nathan.belajar_springboot.service;

import org.springframework.stereotype.Service;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Service
public class EmailService {

    private final Session session;

    public EmailService(Session session) {
        this.session = session;
    }

    public void sendMail() throws Exception {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("kali.jones78@ethereal.email"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("someone@mail.com"));
        message.setSubject("DEMO JAVA MAILER");
        String msg = "If you see this message then the email has been sent successfully!";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }

}
