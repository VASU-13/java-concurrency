package com.vs.callablerunnablefuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableFutureExample {
	
	public static void main(String args[]) {
		
		// Create a fixed thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Define the Callable task inline using a lambda expression
        Callable<Integer> task1 = () -> {
        	Thread.sleep(1000);
            System.out.println("Task executed by " + Thread.currentThread().getName());
            return 42;
        };
        
        Callable<String> task2 = () -> {
        	Thread.sleep(2000);
            System.out.println("Task executed by " + Thread.currentThread().getName());
            return "Another Callable task";
        };

        // Submit the Callable task using submit() and get the result with Future
        Future<Integer> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);
        
        while (!future1.isDone() || !future2.isDone()) {
            System.out.println("Waiting for tasks to complete...");
            try {
                Thread.sleep(500); // Check every 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        
        try {
            // Retrieve and print the results from the Future objects
            System.out.println("Integer task result: " + future1.get());
            System.out.println("String task result: " + future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        
        
        // Shut down the executor
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

}
