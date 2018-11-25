package com.bankrest.util;

import java.util.logging.Logger;

public class LoggingTask extends Thread implements Loggable {
    private static Logger logger;
    private String loggingPoint;

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
