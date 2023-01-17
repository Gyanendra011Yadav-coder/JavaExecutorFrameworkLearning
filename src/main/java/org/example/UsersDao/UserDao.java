package org.example.UsersDao;

import org.example.beans.UsersBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-12,Jan,2023
 * in Project: ExecutorFrameworkLearningProject
 */
public class UserDao {
    public int saveUser(UsersBean userDetails) throws SQLException, ClassNotFoundException {

        int rows=0;

        Connection connectionObject= DBConnection.getConnection();

        PreparedStatement statement = connectionObject.prepareStatement("insert into user values(?,?,?)");

         statement.setInt(1, userDetails.getId());
         statement.setString(2, userDetails.getUserName());
         statement.setString(3, userDetails.getEmailAddress());

         rows=statement.executeUpdate();

         return rows;
    }
}
