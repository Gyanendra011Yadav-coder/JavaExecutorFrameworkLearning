package org.example.runnable;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-20,Jan,2023
 * in Project: ExecutorFrameworkLearningProject
 */
public class CleaningFolderScheduler implements Runnable {

    @Override
    public void run() {

        File folder=new File("C:\\Adda52\\PokerRestLogs\\Controllers");
        File []subFolders=folder.listFiles();

        System.out.println("Traced Below files"+ subFolders.length);
        for (File subFolder : subFolders){
            if((System.currentTimeMillis()-subFolder.lastModified())>1*60*1000){
                System.out.println("Going to clean Folder as it's time greater than 3 minutes"+ subFolder);
            }
            subFolder.delete();
        }
    }
}
