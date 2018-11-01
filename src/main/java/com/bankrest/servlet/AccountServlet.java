package com.bankrest.servlet;

import com.bankrest.model.Account;
import com.bankrest.service.AcountService;
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

    private final AcountService scoreService;
    @Inject
    public AccountServlet(AcountService scoreService) {
       this.scoreService = scoreService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Account accountId = scoreService.getScoreById(Long.valueOf(req.getParameter("accountId")));
        resp.getWriter().print(objectMapper.writeValueAsString(accountId));
    }
}
