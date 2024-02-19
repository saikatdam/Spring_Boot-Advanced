package com.sd.springboot.springmvcsecurity.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController{
    @GetMapping("/")
    public String ReturnHomePage(){
        return "plain-login";
    }
    @GetMapping("/loginPage")
    public String loginPage(){
        return "fancy-login";
    }
    @GetMapping("/OrdersInfo")
    public String OrderInfo(){
        return "Order-Info";
    }
    @GetMapping("/SystematicPerformation")
    public String Systematic(){
        return "Systematic-Perfomation";
    }
}

