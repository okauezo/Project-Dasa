package br.com.fiap.dasa.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {


    private static final String URL = "jdbc:h2:./target/dasa_db;MODE=PostgreSQL";
    private static final String USER = "dasa_user";
    private static final String PASSWORD = "dasa_pass";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}