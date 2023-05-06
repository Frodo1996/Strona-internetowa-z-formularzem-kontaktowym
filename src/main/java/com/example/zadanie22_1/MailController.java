package com.example.zadanie22_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailController {

    private final MailService mailService;
    private final List<MailDto> mails = new ArrayList<>();

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "/contact";
    }

    @PostMapping("/sent")
    public String sendEmail(Model model,
                            @RequestParam String name, @RequestParam String email, @RequestParam String content) {
        MailDto mail = new MailDto(name, email, content);
        mails.add(mail);
        mailService.sendEmail(email, content);
        mailService.sendVerifyingEmailToClient(email);
        model.addAttribute("email", mail);
        return "/sent";
    }

    @GetMapping("/recivedmails")
    public String adminPage(Model model) {
        model.addAttribute("emails", mails);
        return "/recivedmails";
    }

    @GetMapping("/mailsent")
    public String adminInfoPage() {
        return "mailsent";
    }
}