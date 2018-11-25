package com.bankrest.util;

import com.bankrest.dao.H2DaoFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.LogManager;


public class AppManager {
    private final static Injector injector;
    private static final AtomicLong counterThreads = new AtomicLong();
    static {
        H2DaoFactory.populateTestData();
        injector = Guice.createInjector(new BankModule());
        try {

            LogManager.getLogManager()
                    .readConfiguration(
                            Thread.currentThread().getContextClassLoader()
                                    .getResourceAsStream("logging.properties"));
        } catch (IOException e) {
            System.err.println("cannot read logging properties");
        }
    }

    public static long getCounterThreads() {
        long l = counterThreads.incrementAndGet();
        return l;
    }

    public static Injector getInjector() {
        return injector;
    }
}
