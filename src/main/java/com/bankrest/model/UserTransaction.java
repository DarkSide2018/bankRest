package com.bankrest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserTransaction {
    private String currencyCode;
    private BigDecimal amount;
    private Long fromScoreId;
    private Long toScoreId;
}
