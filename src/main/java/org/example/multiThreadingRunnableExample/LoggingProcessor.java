package org.example.multiThreadingRunnableExample;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-18,Jan,2023
 * in Project: ExecutorFrameworkLearningProject
 */
public class LoggingProcessor implements Callable<Boolean> {


    @Override
    public Boolean call() throws Exception {
        Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO, "Logging Something!!!");

        return true;
    }
}
