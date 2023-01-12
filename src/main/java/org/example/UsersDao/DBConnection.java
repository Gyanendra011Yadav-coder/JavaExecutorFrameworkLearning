package org.example.UsersDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-12,Jan,2023
 * in Project: ExecutorFrameworkLearningProject
 */
public class DBConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connectionObject = null;

        Class.forName("com.mysql.jdbc.Driver");

        try {
            connectionObject= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
        }catch (Exception e) {
            Logger.getLogger("Exception", e.getMessage());
        }

        return connectionObject;
    }
}
