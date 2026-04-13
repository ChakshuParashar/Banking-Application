package com.chak.Project.digital_banking_system.service;

import com.chak.Project.digital_banking_system.entity.Account;
import com.chak.Project.digital_banking_system.entity.User;
import com.chak.Project.digital_banking_system.repository.AccountRepository;
import com.chak.Project.digital_banking_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    public Account createAccount(Long userid) {
        User user = userRepository.findById(userid).orElseThrow(()-> new RuntimeException("No User Found"));
        Account account = new Account();
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setAmount(0.0);
        account.setUser(user);
        account.setCreatedAt(LocalDateTime.now());
        accountRepository.save(account);
        return account;
    }
}
