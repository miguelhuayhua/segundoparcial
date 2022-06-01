package com.miguel.parcialdao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URI = "jdbc:mysql://localhost:3306/bd_seminarios?serverTimezone=UTC";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(URI, user, password);
        } catch (SQLException e) {
            System.out.println("No se pudo conectar" + e.toString());
        } finally {
            return connection;
        }
    }

}
