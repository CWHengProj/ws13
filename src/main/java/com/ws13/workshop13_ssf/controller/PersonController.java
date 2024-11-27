package com.ws13.workshop13_ssf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ws13.workshop13_ssf.model.Person;



@Controller
public class PersonController {
    
    @GetMapping("")
    public String createForm(Model model) { 
        //create a new person, add them to the list so that we can display it in the view
        Person person = new Person();
        //i want to add the information from the controller to view, i need a model to do that.
        model.addAttribute(person); 
        return "homePage";
    }
    @PostMapping("/contacts")
    public String contactPage(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}
