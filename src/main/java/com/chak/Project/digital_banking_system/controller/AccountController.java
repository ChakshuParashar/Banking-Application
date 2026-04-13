package com.chak.Project.digital_banking_system.controller;

import com.chak.Project.digital_banking_system.entity.Account;
import com.chak.Project.digital_banking_system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/createAccount{userid}")
    public Account createAccount(@PathVariable Long userid)
    {
       return accountService.createAccount(userid);
    }
}
