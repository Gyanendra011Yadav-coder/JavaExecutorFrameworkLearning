package org.example.beans;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-12,Jan,2023
 * in Project: ExecutorFrameworkLearningProject
 */
public class UsersBean {
    private int Id;
    private String userName;
    private String emailAddress;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


}
