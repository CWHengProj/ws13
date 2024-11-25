package com.ws13.workshop13_ssf.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
    //length between 3 and 64
    @NotEmpty(message = "This field must not be empty.")
    @Size(min = 3, max = 64, message = "Your name must be between 3 and 64 characters in length.")
    private String name;
    //valid email
    @NotEmpty(message = "This field must not be empty.")
    @Email(message="You have to key in a valid email address.")
    private String email;
    //contains at least 7 digits
    @NotEmpty(message = "This field must not be empty.")
    @Max(value=99999999, message = "You have to key in a value between 1111111 to 99999999.")
    @Min(value=1111111, message = "You have to key in a value between 1111111 to 99999999.")
    @Pattern( regexp = "(8|9)[0-9]{7}", message = "Phone number must start with 8 or 9 followed by 7 digits")
    private Integer phoneNumber;
    //cannot be younger than 10, cannot be older than 100
    @NotEmpty(message = "This field must not be empty.")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past( message = "Are you from the future?")
    //TODO calculate the age and validate against the appropriate age range
    private Date dob;
    private String userID;
    
    

    public Person() {
        this.userID= UUID.randomUUID().toString();
    }

    public Person(String name, String email, Integer phoneNumber, Date dob){
        this.userID= UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    
}
