package com.chak.Project.digital_banking_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse <T>{
    private String status;
    private String message;
    private T data;
}
