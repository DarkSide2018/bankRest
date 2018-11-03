package com.bankrest.service;

import com.bankrest.dao.interFaces.AccountDao;
import com.bankrest.model.Account;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AcountService {

    private final AccountDao accountDao;
    @Inject
    public AcountService(AccountDao accountDao) {
       this.accountDao = accountDao;
    }

    public Account getScoreById(long scoreId){
        return accountDao.getScoreById(scoreId);
    }
}
