package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luanv
 */
public class DB {
    public static Connection connect( boolean autoComit){
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "password";


        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(true);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;

}
}