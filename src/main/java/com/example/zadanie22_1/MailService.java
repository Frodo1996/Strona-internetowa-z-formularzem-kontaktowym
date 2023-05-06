package com.example.zadanie22_1;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class MailService {

    private static final String AUTO_RESPONDER_MAIL = "autoresponder@nintendo.pl";
    private static final String AUTO_RESPONDER_SUBJECT = "Wiadomość auto respondera";
    private static final String OWNER_MAIL = "krzysztof@przystarz.pl";
    private static final String DEFAULT_SUBJECT = "Wiadomość z formularza kontaktowego";

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendEmail(String emailAddress, String content) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(OWNER_MAIL);
        mail.setFrom(OWNER_MAIL);
        mail.setReplyTo(emailAddress);
        mail.setSubject(DEFAULT_SUBJECT);
        mail.setText(content);
        mailSender.send(mail);
    }

    public void sendVerifyingEmailToClient(String emailAddress) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(AUTO_RESPONDER_MAIL);
        mail.setTo(emailAddress);
        mail.setSubject(AUTO_RESPONDER_SUBJECT);
        mail.setText(messageToClient());
        mailSender.send(mail);
    }

    private String messageToClient() {
        return """
                Dziękujemy za wiadomości, została ona dostarczona na skrzynkę mailową administratora strony.
                Informujemy, że odpowiedź zostanie udzielona najszybciej jak to możliwe, prosimy o cierpliwość.
                Jest to wiadomość wysyłana automatycznie, nie odpowiadaj na nią.
                Pozdrawiamy serdecznie, zespół Nintendo""";
    }
}