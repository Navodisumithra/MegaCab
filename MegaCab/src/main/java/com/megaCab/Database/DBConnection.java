package com.megaCab.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {private static final String URL = "jdbc:mysql://127.0.0.1:3306/megaCab";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Use the correct password


    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver Not Found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
        return null;
    }


}
