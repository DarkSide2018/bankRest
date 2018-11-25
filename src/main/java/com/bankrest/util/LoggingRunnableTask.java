package com.bankrest.util;

public class LoggingRunnableTask implements Runnable, Loggable {
    private String loggingPoint;

    public LoggingRunnableTask(String loggingPoint) {
        this.loggingPoint = loggingPoint;
    }

    @Override
    public void run() {
        while (true) {
            logger().info("runnable method in  :" + loggingPoint + " point");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
