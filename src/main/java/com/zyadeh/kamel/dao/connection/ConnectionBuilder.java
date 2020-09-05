package com.zyadeh.kamel.dao.connection;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionBuilder {

    private static Connection connection;
    private static final String url = "jdbc:postgresql://localhost:5432/grammar";
    private static final String username = "postgres";
    private static final String password = "12345";

    private ConnectionBuilder() {
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
            DriverManager.registerDriver(new Driver() {
                @Override
                public Connection connect(String s, Properties properties) throws SQLException {
                    return null;
                }

                @Override
                public boolean acceptsURL(String s) throws SQLException {
                    return false;
                }

                @Override
                public DriverPropertyInfo[] getPropertyInfo(String s, Properties properties) throws SQLException {
                    return new DriverPropertyInfo[0];
                }

                @Override
                public int getMajorVersion() {
                    return 0;
                }

                @Override
                public int getMinorVersion() {
                    return 0;
                }

                @Override
                public boolean jdbcCompliant() {
                    return false;
                }

                @Override
                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    return null;
                }
            });
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
