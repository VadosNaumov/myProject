package com.nav.spboo.controller;

import com.nav.spboo.model.Mail;
import com.nav.spboo.model.User;
import com.nav.spboo.service.MailService;
import com.nav.spboo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MailController {

    private final MailService mailService;
    private final UserService userService;

    public MailController(MailService mailService, UserService userService) {
        this.mailService = mailService;
        this.userService = userService;
    }

    @GetMapping("/mails")
    public String findAll(Model model) {
        List<Mail> mails = mailService.findAll();
        mails.sort(Mail::compareTo);
        model.addAttribute("mails", mails);
        return "mail-list";
    }

    @GetMapping("/mail-create")
    public String createMailForm(Mail mail, Model model) {
        model.addAttribute("mail", mail);

        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "mail-create";
    }

    @PostMapping("/mail-create")
    public String createMail(Mail mail) {
        mailService.saveMail(mail);
        return "redirect:/mails";
    }

    @GetMapping("/mail-delete/{id}")
    public String deleteMail(@PathVariable("id") Long id) {
        mailService.deleteById(id);
        return "redirect:/mails";
    }

    @GetMapping("/mail-update/{id}")
    public String updateMailForm(@PathVariable("id") Long id, Model model) {
        Mail mail = mailService.findById(id);
        model.addAttribute("mail", mail);

        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "mail-update";
    }

    @PostMapping("/mail-update")
    public String updateMail(Mail mail) {
        mailService.saveMail(mail);
        return "redirect:/mails";
    }
}
