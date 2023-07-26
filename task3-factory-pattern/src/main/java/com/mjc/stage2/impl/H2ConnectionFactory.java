package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    // Write your code here!
    @Override
    public Connection createConnection() {
        Properties info = getH2Properties();
        try {
            return DriverManager.getConnection(info.getProperty("db_url"), info);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Properties getH2Properties() {
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        InputStream stream = loader.getResourceAsStream("h2database.properties");
        try {
            props.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return props;
    }
}

