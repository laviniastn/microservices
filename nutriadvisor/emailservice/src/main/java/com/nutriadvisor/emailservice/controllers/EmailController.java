package com.nutriadvisor.emailservice.controllers;

import com.nutriadvisor.emailservice.dto.EmailDTO;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    private static final Logger logger = Logger.getLogger(EmailController.class);


    @PostMapping(value = "/send")
    public String sendEmail(@RequestBody EmailDTO emailDTO) {
        logger.setLevel(Level.DEBUG);

        String from = emailDTO.getSender();
        String to = emailDTO.getRecipient();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(emailDTO.getSubject());
        message.setText(emailDTO.getMessage());

        mailSender.send(message);

        logger.debug("Email sent");
        return "Email sent";
    }
}
