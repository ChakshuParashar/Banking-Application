package com.chak.Project.digital_banking_system.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TransferRequest {
    @NotNull  ( message= "From account ID is required")
    private Long fromAccountId;
    @NotNull ( message = "To Account ID is required" )
    private Long toAccountId;
    @Min(value = 1 ,message = "Min Amount Should be greater than 0")
    private Double amount;
}
