package org.example.ExecutorFrameworkSubTopics;

import org.example.runnable.CleaningFolderScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-20,Jan,2023
 * in Project: ExecutorFrameworkLearningProject
 */
public class SchedulerForDeletingFile {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        System.out.println("Starting scheduler for cleaning of file.....");
        executorService.schedule(new CleaningFolderScheduler(),5, TimeUnit.SECONDS);

        //Intial-Delay is the time after which process will start executing the task, period time is the time for which it will be waiting
        executorService.scheduleAtFixedRate(new CleaningFolderScheduler(),5,4 ,TimeUnit.SECONDS);

        //Delay time starts it coutn once initial Delay ends
        executorService.scheduleWithFixedDelay(new CleaningFolderScheduler(),5,4 ,TimeUnit.SECONDS);
    }
}
