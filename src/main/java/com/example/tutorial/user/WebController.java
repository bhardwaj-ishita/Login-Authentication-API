package com.example.tutorial.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * To control the web flow of the website
 */

@Controller
public class WebController {
    @RequestMapping("/")
    public String landing(){
        return "landing.html";
    }

    @RequestMapping("/register")
    public String register(){

        return "register.html";
    }

    @RequestMapping("/login")
    public String login(){
        return "login.html";
    }

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard.html";
    }

}

