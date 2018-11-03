package com.bankrest.util;

import com.bankrest.dao.H2DaoFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;


public class AppManager {
    private final static Injector injector;
    static {
        H2DaoFactory.populateTestData();
        injector = Guice.createInjector(new BankModule());
        }

    public static Injector getInjector() {
        return injector;
    }
}
