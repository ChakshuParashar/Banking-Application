package com.chak.Project.digital_banking_system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferRequest {
    private Long fromAcoountId;
    private Long toAccountId;
    private Double amount;
}
