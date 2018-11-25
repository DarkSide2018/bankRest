package com.bankrest.servlet;

import com.bankrest.dao.BankDao;
import com.bankrest.model.UserTransaction;
import com.bankrest.util.AppManager;
import com.bankrest.util.LoggingTask;
import com.google.inject.Inject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Logger;

@WebServlet(name = "BankServlet", urlPatterns = {"/bank"}, loadOnStartup = 1)
public class BankServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(BankServlet.class.getName());
    private BankDao bankDao;

    public BankServlet() {
        this.bankDao = AppManager.getInjector().getInstance(BankDao.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String fromScore = req.getParameter("fromAccount");
            if (fromScore == null) throw new Exception("fromScore empty");
            String toScore = req.getParameter("toAccount");
            String currency = req.getParameter("currency");
            String amount = req.getParameter("amount");
            UserTransaction userTransaction = new UserTransaction(currency, new BigDecimal(amount), Long.valueOf(fromScore), Long.valueOf(toScore));
            bankDao.transferMoney(userTransaction);
            resp.getWriter().println("successTransfer");
        } catch (Exception e) {

        }
    }

    @Inject
    public void init() {
        Thread th = new LoggingTask("In BankServlet");
        th.start();
    }
}
