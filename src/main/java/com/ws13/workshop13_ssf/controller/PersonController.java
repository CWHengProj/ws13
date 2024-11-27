package com.ws13.workshop13_ssf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ws13.workshop13_ssf.model.Person;
import com.ws13.workshop13_ssf.service.Contacts;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class PersonController {
    final private String dataDir;
    private Contacts contacts;
    @Autowired //constructor injection, make these values accessible in the class level
    public PersonController(String dataDir, Contacts contacts) {
        this.dataDir = dataDir;
        this.contacts = contacts;
    }
    
    @GetMapping("/")
    public String createForm(Model model) { 
        //create a new person, add them to the list so that we can display it in the view
        Person person = new Person();
        //i want to add the information from the controller to view, i need a model to do that.
        model.addAttribute("person", person);
        return "homePage";
    }   
    @PostMapping("/contact")
    public String contactPage(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model, RedirectAttributes redAtt) {
        //when post request is sent, create a UUID - create a user
        List<Contacts> contactsList = contacts.getContactList();
        //go through checks for duplicate names and emails
        if (contacts.checkForDuplicateEmailName(contactsList, person)){
            //perform a check for duplicates
            //if false, return error mesage

        }
        else{
            contacts.createFile(person);
            //create a file with the hex string in the stated directory when running the app
            //write the data into the file - line by line, with uuid as the title
            
            //variables sent to view using Model model
            //once complete, controller return the code with an appropriate message - done by passing redirectAttributes to the view
        }
        return "redirect:/addSuccessful"; //send the user to the getMapping addSuccessful
    }
    @GetMapping("/addSuccessful")
    public String getMethodName() {
        return "addSuccessful"; // return page
    }
    
    
}
