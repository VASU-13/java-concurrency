package com.vs.completablefuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Simulate a long-running process of fetching user data
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (Math.random() < 0.5) {
                throw new RuntimeException("Failed to fetch user data");
            }
            return "User Data";
        });

        //  Add thenApply() to process the user data
        CompletableFuture<String> resultFuture = userFuture.thenApply(result-> result + " fetched")
                .exceptionally(ex -> "Default Value due to Error " + ex.getMessage());
        //  Chain exceptionally() to handle any errors and return a default value

        // Get the result (blocking operation)
        String result = resultFuture.get();  // This should store the result after exception handling is applied
        System.out.println(result);


    }
}
