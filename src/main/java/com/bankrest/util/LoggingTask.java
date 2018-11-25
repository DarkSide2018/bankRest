package com.bankrest.util;

import org.h2.tools.RunScript;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingTask extends Thread implements Loggable {
    private String loggingPoint;
    private static   Logger logger;
    public LoggingTask(String className) {
        logger = logger();
        this.loggingPoint = className;

    }

    @Override
    public void run() {
        while (true) {
           logger.info("Test logging method in :" + loggingPoint + " point");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
