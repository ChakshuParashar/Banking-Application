package com.chak.Project.digital_banking_system.mapper;

import com.chak.Project.digital_banking_system.dto.UserResponse;
import com.chak.Project.digital_banking_system.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Usermapper {
    public UserResponse mapToDTO(User user)
    {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUserName());
        return dto;
    }
}
