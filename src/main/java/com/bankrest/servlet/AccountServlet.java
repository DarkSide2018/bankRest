package com.bankrest.servlet;

import com.bankrest.model.Account;
import com.bankrest.service.AcountService;
import com.bankrest.util.AppManager;
import com.bankrest.util.LoggingRunnableTask;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountServlet", urlPatterns = {"/account"}, loadOnStartup = 1)
public class AccountServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    private final AcountService acountService;

    public AccountServlet() {

        this.acountService = AppManager.getInjector().getInstance(AcountService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Account accountId = acountService.getScoreById(Long.valueOf(req.getParameter("accountId")));
        resp.getWriter().print(objectMapper.writeValueAsString(accountId));
    }
    @Inject
    public void init() {
        Thread th = new Thread(new LoggingRunnableTask("AccountServlet point"));
        th.start();
    }
}
