package com.chak.Project.digital_banking_system.service;

import com.chak.Project.digital_banking_system.configuration.JWTUtil;
import com.chak.Project.digital_banking_system.configuration.SecurityConfig;
import com.chak.Project.digital_banking_system.dto.Login;
import com.chak.Project.digital_banking_system.dto.PageResponse;
import com.chak.Project.digital_banking_system.dto.RegisterUser;
import com.chak.Project.digital_banking_system.dto.UserResponse;
import com.chak.Project.digital_banking_system.entity.User;
import com.chak.Project.digital_banking_system.exception.UserNotFoundException;
import com.chak.Project.digital_banking_system.mapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.chak.Project.digital_banking_system.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private Usermapper usermapper;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JWTUtil jwtUtil;

    public User addUser(User user) {
      return userRepository.save(user);
    }

    public User registerUser(RegisterUser registerUser)
    {
        log.info("bakasur hai");
        User user = new User();
        user.setUserName(registerUser.getName());
        user.setEmail(registerUser.getEmail());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
      return userRepository.save(user);
    }

    public String login(Login login) {
        User user = userRepository.findByEmail(login.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        if(!passwordEncoder.matches(login.getPassword(),user.getPassword())){
            throw  new RuntimeException("No User Found");
        }

        return jwtUtil.generateToken(user.getEmail(),user.getRole());
    }

    public PageResponse<UserResponse> getAllUser(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy).descending());
        Page<User> userPage= userRepository.findAll(pageable);
        List<UserResponse> dtoList = userPage.getContent().stream().map(usermapper::mapToDTO).toList();
        PageResponse<UserResponse> response = new PageResponse<>();
        response.setContent(dtoList);
        response.setPage(userPage.getNumber());
        response.setSize(userPage.getSize());
        response.setTotalelemant(userPage.getTotalElements());
        response.setTotalpage(userPage.getTotalPages());
        return response;
    }
}
