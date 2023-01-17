package org.example.runnable;

import org.example.UsersDao.UserDao;
import org.example.beans.UsersBean;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-12,Jan,2023
 * in Project: ExecutorFrameworkLearningProject
 */
public class UserProcessor implements Callable<Integer> {
    private String userRecord;
    private UserDao userDao;

    public UserProcessor(String userRecord, UserDao userDao) {
        this.userRecord = userRecord;
        this.userDao = userDao;
    }

    @Override
    public Integer call() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(userRecord, ",");
        int row = 0;

        System.out.println(Thread.currentThread().getName() + ": Processing Record for -->" + userRecord);

        UsersBean user = null ;
        while(tokenizer.hasMoreTokens()) {
            user=new UsersBean();
            user.setEmailAddress(tokenizer.nextToken());
            user.setUserName(tokenizer.nextToken());
            user.setId(Integer.valueOf(tokenizer.nextToken()));

            row=userDao.saveUser(user);
        }
        return row;
    }
}
