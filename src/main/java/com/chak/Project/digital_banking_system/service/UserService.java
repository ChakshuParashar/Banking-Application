package com.chak.Project.digital_banking_system.service;

import com.chak.Project.digital_banking_system.configuration.SecurityConfig;
import com.chak.Project.digital_banking_system.dto.RegisterUser;
import com.chak.Project.digital_banking_system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.chak.Project.digital_banking_system.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getAllUser() {
       return userRepository.findAll();
    }

    public User addUser(User user) {
      return userRepository.save(user);
    }

    public User registerUser(RegisterUser registerUser)
    {
        User user = new User();
        user.setUserName(registerUser.getName());
        user.setEmail(registerUser.getEmail());
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
      return userRepository.save(user);
    }

}
