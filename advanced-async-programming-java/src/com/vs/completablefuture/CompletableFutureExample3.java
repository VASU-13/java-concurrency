package com.vs.completablefuture;

/*
    This is different from thenApply(), which transforms the result of a single CompletableFuture.
    In contrast, thenCombine() is used when you want to merge the results of two asynchronous tasks running in parallel.
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create the first CompletableFuture that returns "Hello"
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        });

        // Create the second CompletableFuture that returns "World"
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "World";
        });

        // Combine both futures using thenCombine() to merge their results into one string
        CompletableFuture<String> combineFuture = future1.thenCombine(future2, (a,b)-> a+b);

        // Get the result (blocking operation)
        String result = combineFuture.get(); // This should store the combined result
        System.out.println(result);  // Should print "Hello World"
    }
}
