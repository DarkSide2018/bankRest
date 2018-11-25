package com.bankrest.util;

import com.bankrest.dao.H2DaoFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.LogManager;


public class AppManager {
    private final static Injector injector;
    private static final AtomicLong counterThreads = new AtomicLong();
    public static final String FILE_HANDLER_PATTERN = "java.util.logging.FileHandler.pattern";

    public static final String LOGGING_PROPERTIES = "logging.properties";

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
