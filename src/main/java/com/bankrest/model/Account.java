package com.bankrest.model;

import java.math.BigDecimal;


public class Account {
    private long id;
    private final long userId;
    private final BigDecimal balance;
    private final String currencyCode;

    public Account(long id, long userId, BigDecimal balance, String currencyCode) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.currencyCode = currencyCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
