package com.bankrest.service;

import com.bankrest.dao.interFaces.AccountDao;
import com.bankrest.model.Account;
import com.bankrest.util.Loggable;
import com.bankrest.util.LoggingTask;
import com.google.inject.Inject;

import javax.inject.Singleton;

@Singleton
public class AcountService implements Loggable {

    private final AccountDao accountDao;

    @Inject
    public AcountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account getScoreById(long scoreId) {
        return accountDao.getScoreById(scoreId);
    }

    @Inject
    public void init() {
        Thread th = new LoggingTask("Point In Account Service");
        th.start();
    }
}
