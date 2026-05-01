package org.example.execice_ticket_emailnotification.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailTickets {

    // 1. Retire le mot-clé 'static'
    @Autowired
    private JavaMailSender emailClient;

    // 2. Retire le mot-clé 'static'
    @Value("${spring.mail.username}")
    private String fromEmail;

    // 3. Retire le mot-clé 'static' de la méthode
    public void sendWelcomeEmail(String toEmail, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject("Bienvenue sur notre plateforme !");
        message.setText("Bonjour " + name + ",\nVotre ticket a été créé avec succès.");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        emailClient.send(message);
    }
}

