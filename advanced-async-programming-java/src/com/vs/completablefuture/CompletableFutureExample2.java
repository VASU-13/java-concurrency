package com.vs.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> dataFuture = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Data Fetched";
        });

        //thenAccept() to print the result of the CompletableFuture.
        //thenRun() to log a message when the task has completed.
        dataFuture.thenAccept(System.out::println).thenRun(()->{
            System.out.println("Task Completed");
        });

        dataFuture.get();
    }
}
