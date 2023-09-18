package com.api.v1.salario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String showForm() {
        return "index";
    }
    @GetMapping("/home")
    public String showHome(){return "home";}
}
