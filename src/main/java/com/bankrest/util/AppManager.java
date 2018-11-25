package com.bankrest.util;

import com.bankrest.dao.H2DaoFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.net.URL;
import java.util.logging.LogManager;


public class AppManager {
    private final static Injector injector;

    static {
        H2DaoFactory.populateTestData();
        injector = Guice.createInjector(new BankModule());
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            LogManager.getLogManager()
                    .readConfiguration(
                            contextClassLoader
                                    .getResourceAsStream("logging.properties"));
        } catch (IOException e) {
            System.err.println("cannot read logging properties");
        }
    }

    public static Injector getInjector() {
        return injector;
    }
}
