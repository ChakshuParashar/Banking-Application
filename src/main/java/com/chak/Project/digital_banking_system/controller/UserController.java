package com.chak.Project.digital_banking_system.controller;

import com.chak.Project.digital_banking_system.entity.User;
import com.chak.Project.digital_banking_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public List<User> GetAllUser()
    {
        return userService.getAllUser();
    }

    @PostMapping("/addUser")
    public User adduser(@RequestBody User user)
    {
       return userService.addUser(user);
    }
}
