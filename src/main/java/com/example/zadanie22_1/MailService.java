package com.example.zadanie22_1;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private static final String MAIL_RECEIVER = "mailpit.javastart.pl";

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String emailAddress, String content) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(MAIL_RECEIVER);
        mail.setFrom(emailAddress);
        mail.setText(content);
        mailSender.send(mail);
    }
}