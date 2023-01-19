package org.example;

import org.example.UsersDao.UserDao;
import org.example.runnable.UserProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created By:  Gyanendra_Yadav
 * on ${DATE},${MONTH_NAME_SHORT},${YEAR}
 * in Project: ${PROJECT_NAME}
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        List<String> usersList= getUserFromFile("C:\\Users\\Gyanendra-Yadav\\Downloads\\Ex_Files_Java_EE_Concurrency\\Exercise Files\\Chapter3\\03_07\\begin\\javaseconcurrency\\new_users.txt");
        Logger.getLogger("Users list: " + usersList);

        UserDao userDao = new UserDao();
        for (String user : usersList){
            Future<Integer> futureObj=executor.submit(new UserProcessor(user,userDao)); // Future is used to store the Output
            System.out.println("Result of the operation is: " + futureObj.get());
        }
        executor.shutdown();
        System.out.println("Main Execution is Over now......!");
    }

    public static List<String> getUserFromFile(String fileName) {
        List<String> users = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + ": Reading Line " + line);
                users.add(line);
            }
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    };
}