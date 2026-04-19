package com.chak.Project.digital_banking_system.controller;

import com.chak.Project.digital_banking_system.dto.*;
import com.chak.Project.digital_banking_system.entity.User;
import com.chak.Project.digital_banking_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public APIResponse<PageResponse<UserResponse>> getusers(
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "5") int size,
            @RequestParam (defaultValue = "id") String sortBy
    )
    {
        PageResponse<UserResponse> users =userService.getAllUser(page,size,sortBy);
        return new APIResponse<>("Success","User Fetched",users);
    }

    @PostMapping("/addUser")
    public User adduser(@RequestBody User user)
    {
       return userService.addUser(user);
    }

    @PostMapping("/register")
    public User register( @Valid  @RequestBody RegisterUser registerUser)
    {
        return userService.registerUser(registerUser);
    }

    @PostMapping("/login")
    public APIResponse<String> loginuser(@RequestBody Login login )
    {
     String token =  userService.login(login);
        return new APIResponse<>("SUCCESS", "Login successful", token);
    }
}
