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
public class Account {
    private long id;
    private long userId;
    private BigDecimal balance;
    private String currencyCode;


}
