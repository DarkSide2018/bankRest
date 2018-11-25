package com.bankrest.util;

import java.util.logging.Logger;

public interface Loggable {
    default Logger logger() {
        return Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClass().getName());
    }
}
