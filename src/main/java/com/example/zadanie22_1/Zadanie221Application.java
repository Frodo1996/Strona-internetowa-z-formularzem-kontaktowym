package com.example.zadanie22_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zadanie221Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zadanie221Application.class, args);
        MailService mailService = context.getBean(MailService.class);

    }

}
