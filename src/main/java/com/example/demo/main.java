package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class main {
    @RequestMapping(value = "login")
    public String login(){
        return "欢迎你";
    }
}
