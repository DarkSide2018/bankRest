package com.bankrest.util;

import com.bankrest.dao.BankDao;
import com.bankrest.dao.H2DaoFactory;
import com.bankrest.dao.AccountDaoImpl;
import com.bankrest.dao.UserDaoImpl;
import com.bankrest.dao.interFaces.AccountDao;
import com.bankrest.dao.interFaces.UserDao;
import com.bankrest.service.AcountService;
import lombok.Getter;

@Getter
public class AppManager {
    private final AccountDao accountDao;
    private final UserDao userDao;
    private final BankDao bankDao;
    private final AcountService accountService;

    public AppManager() {
        accountDao = new AccountDaoImpl();
        accountService = new AcountService(accountDao);
        bankDao = new BankDao();
        userDao = new UserDaoImpl();
    }

    static {
        H2DaoFactory.populateTestData();
    }
}
