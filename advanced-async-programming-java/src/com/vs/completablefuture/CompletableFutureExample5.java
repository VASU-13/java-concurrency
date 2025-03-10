package com.vs.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


/*
    orTimeout() method, which allows you to specify a time limit for the completion of an asynchronous task.
    If the task takes longer than the specified time, an exception is triggered, and a default message is returned.

 */

public class CompletableFutureExample5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Simulate a long-running process of fetching user data
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "User Data";
        });

        //  Add thenApply() to process the user data
        CompletableFuture<String> resultFuture = userFuture.orTimeout(2000, TimeUnit.MILLISECONDS)
                .exceptionally(ex-> "Time out occured ");
        //  Chain exceptionally() to handle any errors and return a default value

        // Get the result (blocking operation)
        String result = resultFuture.get();  // This should store the result after exception handling is applied
        System.out.println(result);


    }
}
