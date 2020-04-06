package com.nav.spboo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "main";
    }

    @RequestMapping("/main")
    public String goMain() {
        return "main";
    }
}
