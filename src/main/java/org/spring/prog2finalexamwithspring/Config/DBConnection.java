package org.spring.prog2finalexamwithspring.Config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
public class DBConnection {
    private final String jdbc_url;
    private final String username;
    private final String password;

    public DBConnection() {
        Dotenv dotenv = Dotenv.load();
        jdbc_url = dotenv.get("DB_URL");
        username = dotenv.get("DB_USER");
        password = dotenv.get("DB_PASSWORD");
    }

    public Connection getConnection(){
        Connection connection = null;
        try{
            connection = java.sql.DriverManager.getConnection(jdbc_url, username, password);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void CloseConnection(Connection connection){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
