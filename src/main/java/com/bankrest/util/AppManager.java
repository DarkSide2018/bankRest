package com.bankrest.util;

import com.bankrest.dao.BankDao;
import com.bankrest.dao.H2DaoFactory;
import com.bankrest.dao.ScoreDaoImpl;
import com.bankrest.dao.UserDaoImpl;
import com.bankrest.dao.interFaces.ScoreDao;
import com.bankrest.dao.interFaces.UserDao;
import com.bankrest.service.ScoreService;


public class AppManager {
    private static final ScoreDao scoreDao = new ScoreDaoImpl();
    private static final UserDao userDao = new UserDaoImpl();
    private static final BankDao bankDao = new BankDao();
    private static final ScoreService scoreService = new ScoreService();

    public AppManager() {

    }

    public static ScoreDao getScoreDao() {
        return scoreDao;
    }

    public static UserDao getUserDao() {
        return userDao;
    }

    public static BankDao getBankDao() {
        return bankDao;
    }

    public static ScoreService getScoreService() {
        return scoreService;
    }
    static {

        H2DaoFactory.populateTestData();
    }
}
