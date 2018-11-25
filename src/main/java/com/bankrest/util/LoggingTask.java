package com.bankrest.util;

public class LoggingTask extends Thread implements Loggable {
    private String loggingPoint;

    public LoggingTask(String className) {
        this.loggingPoint = className;
    }

    @Override
    public void run() {
        while (true) {
            logger().info("Test logging method in :" + loggingPoint + " point");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
