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
    }
}
