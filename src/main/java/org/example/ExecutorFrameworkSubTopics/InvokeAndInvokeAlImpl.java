package org.example.ExecutorFrameworkSubTopics;

import org.example.multiThreadingRunnableExample.LoggingProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-18,Jan,2023
 * in Project: ExecutorFrameworkLearningProject
 */
public class InvokeAndInvokeAlImpl {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(5);

        List<Callable<Boolean>> callables = new ArrayList<>();

        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());

        List<Future<Boolean>> futureList=service.invokeAll(callables);

        for(Future<Boolean> future : futureList){
            System.out.println("Operations"+ future.get());
        }

        System.out.println("Start Executung it With InvokeAny() Method");
        boolean result=service.invokeAny(callables);
        System.out.println(result);
    }
}
