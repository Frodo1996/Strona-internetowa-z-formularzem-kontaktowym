package com.example.zadanie22_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MailController {

    ArrayList<Mail> mails = new ArrayList<>();
    @GetMapping("/contact")
    public String contactPage() {
        return "/contact";
    }

    @GetMapping("/sent")
    public String sent(Model model,
                       @RequestParam String name, @RequestParam String email, @RequestParam String content) {
        Mail mail = new Mail(name, email, content);
        mails.add(mail);
        model.addAttribute("email", mail);
        return "/sent";
    }

    @GetMapping("/recivedmails")
    public String adminPage(Model model) {
        model.addAttribute("emails", mails);
        return "/recivedmails";
    }

    @GetMapping("/mailsended")
    public String adminInfoPage(Model model) {
        return "/mailsended";
    }
}