package com.vs.callablerunnablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InvokeAllExample {
	
	public static void main(String args[]) {
		
		// Create a fixed thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Define a list of Callable tasks
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() -> 10);
        tasks.add(() -> 20);
        tasks.add(() -> 30);

        try {
            // TODO: Submit the list of Callable tasks using invokeAll()

            // TODO: Retrieve the results from the Future objects

            // TODO: Print the results from each Callable task
        	
        	List<Future<Integer>> list = executor.invokeAll(tasks);
        	for(Future<Integer> f : list) {
        		System.out.println(f.get());
        	}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shut down the executor
            executor.shutdown();
        }
    }

}
