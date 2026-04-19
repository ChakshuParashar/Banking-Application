package com.chak.Project.digital_banking_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/admin")
    public String adminTest()
    {
        return "Admin Is Logged In";
    }

    @GetMapping("/user")
    public String userTest()
    {
       return "User Is Logged In" ;
    }
}
