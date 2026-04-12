package com.chak.Project.digital_banking_system.service;

import com.chak.Project.digital_banking_system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chak.Project.digital_banking_system.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> getAllUser() {
       return userRepository.findAll();
    }

    public User addUser(User user) {
      return userRepository.save(user);
    }
}
