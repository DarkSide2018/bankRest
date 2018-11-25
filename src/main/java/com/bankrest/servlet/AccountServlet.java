package com.bankrest.servlet;

import com.bankrest.model.Account;
import com.bankrest.service.AcountService;
import com.bankrest.util.AppManager;
import com.bankrest.util.Loggable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "AccountServlet", urlPatterns = {"/account"}, loadOnStartup = 1)
public class AccountServlet extends HttpServlet implements Loggable {
    private ObjectMapper objectMapper = new ObjectMapper();
    private static Logger log = Logger.getLogger(AccountServlet.class.getName());
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
    //Like a postConstruct in EJB
    public void init(){
        while (true){
            logger().info("Init Method in account servlet");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
