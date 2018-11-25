package com.bankrest.dao;

import com.bankrest.util.Util;
import org.apache.commons.dbutils.DbUtils;
import org.h2.tools.RunScript;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class H2DaoFactory {
    private static final String dbDriver = Util.getStringProperty("dbDriver");
    private static final String dbUrl = Util.getStringProperty("dbUrl");
    private static final String dbUser = Util.getStringProperty("dbUser");
    private static final String dbPassword = Util.getStringProperty("dbPassword");
    private static Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClass().getName());

    static {
        DbUtils.loadDriver(dbDriver);
    }

    public static void populateTestData() {
        logger.info("Populating Test User Table and data ..... ");
        try (Connection conn = H2DaoFactory.getConnection()) {
            final InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("populateDB.sql");
            RunScript.execute(conn, new InputStreamReader(fis));
        } catch (SQLException e) {
            logger.warning("populateTestData(): Error populating user data: ");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
}
