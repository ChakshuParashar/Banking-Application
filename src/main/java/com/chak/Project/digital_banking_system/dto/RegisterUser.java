package com.chak.Project.digital_banking_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUser {
    @NotBlank(message = "Name Should Not be empty!!")
    private String name;
    @Email(message ="Email format Is Invalid")
    @NotBlank(message ="Email Should Not be Blank")
    private String email;
    @NotBlank(message ="Password Should Not be Blank")
    @Size(min = 6 ,message = "Should must be at least 6 Character")
    private String password;
}
