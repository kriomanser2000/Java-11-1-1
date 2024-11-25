package com.example.notepaddb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil
{
    private static final String PROPERTIES_FILE = "/db.properties";
    public static Connection getConnection() throws SQLException
    {
        Properties properties = new Properties();
        try (var inputStream = DatabaseUtil.class.getResourceAsStream(PROPERTIES_FILE))
        {
            properties.load(inputStream);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to load database properties", e);
        }
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);
    }
}
