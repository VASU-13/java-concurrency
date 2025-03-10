package com.vs.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate long-running computation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        });

        // Chaining tasks using thenApply() and handling exceptions
        CompletableFuture<String> resultFuture = future
                .thenApply(greeting -> greeting + " World!")
                .exceptionally(ex -> "An error occurred: " + ex.getMessage());

        // Get the result (blocking operation)
        String result = resultFuture.get();
        System.out.println(result);
    }

}
