package com.vs.threadpoolsexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewFixedThreadPoolExample {
	
	public static void main(String args[]) {
		
		// Create a fixed thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit Runnable tasks using execute()
        // execute method use Runnable instance
        executor.execute(() -> {
            System.out.println("Task 1 executed by " + Thread.currentThread().getName());
        });

        executor.execute(() -> {
            System.out.println("Task 2 executed by " + Thread.currentThread().getName());
        });
        
        executor.execute(() -> {
            System.out.println("Task 3 executed by " + Thread.currentThread().getName());
        });
        
        executor.execute(() -> {
            System.out.println("Task 4 executed by " + Thread.currentThread().getName());
        });
		
		
        // Shut down the executor gracefully
        executor.shutdown();

        try {
            // Await termination for up to 5 seconds
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();  // Force shutdown if tasks didn't finish
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
		
	}

}
