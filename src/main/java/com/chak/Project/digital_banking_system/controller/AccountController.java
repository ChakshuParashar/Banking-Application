package com.chak.Project.digital_banking_system.controller;

import com.chak.Project.digital_banking_system.dto.TransferRequest;
import com.chak.Project.digital_banking_system.entity.Account;
import com.chak.Project.digital_banking_system.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.chak.Project.digital_banking_system.dto.APIResponse;
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/createAccount{userid}")
    public Account createAccount(@PathVariable Long userid)
    {
       return accountService.createAccount(userid);
    }

    @PostMapping("/transfer")
    public APIResponse<String> transfer ( @Valid  @RequestBody TransferRequest request)
    {
     return accountService.transerAmount(request);
    }
}
