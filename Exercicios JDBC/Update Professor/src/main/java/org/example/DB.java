package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luanv
 */
public class DB {
    public static Connection connect(){
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "password";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

}