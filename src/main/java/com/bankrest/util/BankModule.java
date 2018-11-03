package com.bankrest.util;

import com.bankrest.dao.AccountDaoImpl;
import com.bankrest.dao.interFaces.AccountDao;
import com.google.inject.AbstractModule;

public class BankModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(AccountDao.class).to(AccountDaoImpl.class);
    }
}
