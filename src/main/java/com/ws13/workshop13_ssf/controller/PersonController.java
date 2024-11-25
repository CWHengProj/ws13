package com.ws13.workshop13_ssf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PersonController {

    @GetMapping("/homePage")
    public String toHomePage() {
        return "homePage";
    }
    
}
