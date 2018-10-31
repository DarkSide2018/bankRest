package com.bankrest.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserTransaction {
    private String currencyCode;
    private  BigDecimal amount;
    private  Long fromScoreId;
    private Long toScoreId;
}
