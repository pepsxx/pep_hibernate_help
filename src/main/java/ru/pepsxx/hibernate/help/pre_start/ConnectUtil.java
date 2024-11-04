package ru.pepsxx.hibernate.help.pre_start;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectUtil {

    private ConnectUtil() {
    }

    static public Connection getConnection() throws SQLException, IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("src/main/resources/hibernate.properties");
        properties.load(inputStream);
        String url = properties.getProperty("hibernate.connection.url");
        String user = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        return DriverManager.getConnection(url, user, password);
    }

}
