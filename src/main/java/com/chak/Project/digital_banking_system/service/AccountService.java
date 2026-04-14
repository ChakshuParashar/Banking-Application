package com.chak.Project.digital_banking_system.service;

import com.chak.Project.digital_banking_system.dto.TransferRequest;
import com.chak.Project.digital_banking_system.entity.Account;
import com.chak.Project.digital_banking_system.entity.User;
import com.chak.Project.digital_banking_system.repository.AccountRepository;
import com.chak.Project.digital_banking_system.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.chak.Project.digital_banking_system.dto.APIResponse;
import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class AccountService {
    private  static final Logger logger = LoggerFactory.getLogger(AccountService.class);

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

    @Transactional
    public APIResponse<String> transerAmount(TransferRequest request) {
        logger.info("Checkni");
        Account fromAccount = accountRepository.findById(request.getFromAccountId()).orElseThrow(() ->new RuntimeException("No Account Find"));
        Account toAccount = accountRepository.findById(request.getToAccountId()).orElseThrow(() ->new RuntimeException("No Account Find"));
        if(request.getAmount() > fromAccount.getBalance())
        {
           throw  new RuntimeException("Fund Not Available");
        }
        // setting remaining ammount
        fromAccount.setBalance(fromAccount.getBalance() - request.getAmount());
        // add to Account
        toAccount.setBalance(toAccount.getBalance() + request.getAmount());
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        return new APIResponse<String>("SUCCESS", "Transfer successful", null);
    }
}
