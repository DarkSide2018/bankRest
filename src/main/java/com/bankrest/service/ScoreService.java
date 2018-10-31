package com.bankrest.service;

import com.bankrest.dao.interFaces.ScoreDao;
import com.bankrest.model.Account;
import com.bankrest.util.AppManager;

public class ScoreService {

    private final ScoreDao scoreDao;

    public ScoreService() {
        this.scoreDao = AppManager.getScoreDao();
    }

    public Account getScoreById(long scoreId){
        return scoreDao.getScoreById(scoreId);
    }
}
