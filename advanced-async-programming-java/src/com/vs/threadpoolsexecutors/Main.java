package com.vs.threadpoolsexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * 
 * Your task is to write a class named ApiFetcher to manage the API fetching logic and submit the tasks to a thread pool. 
 * Ensure the ExecutorService is properly shut down after all tasks are completed.
 */

public class Main {
    public static void main(String[] args) {
        // Create a fixed thread pool with 4 threads
    	
    	ExecutorService executor = Executors.newFixedThreadPool(4);

        //  Submit 4 API fetching tasks to the thread pool using the ApiFetcher class
    	ApiFetcher task1 = new ApiFetcher("my-api-1");
    	ApiFetcher task2 = new ApiFetcher("my-api-2");
    	ApiFetcher task3 = new ApiFetcher("my-api-3");
    	ApiFetcher task4 = new ApiFetcher("my-api-4");
    	// instead of submit method execute can also be used
    	executor.submit(task1);
    	executor.submit(task2);
    	executor.submit(task3);
    	executor.submit(task4);
    	
    	
    
        //  Shut down the executor gracefully
    	
    	executor.shutdown();

        //  Await termination for up to 5 seconds, then force shutdown if necessary
    	try {
    		if(!executor.awaitTermination(5, TimeUnit.SECONDS)) {
    			executor.shutdownNow();
    		}
    	}
    	catch(InterruptedException e) {
    		executor.shutdownNow();
    	}
    }
}