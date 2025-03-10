package com.vs.callablerunnablefuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 
 * 
 * Write a complete Java program in which you define a Callable<Integer> 
 * that calculates the sum of the first 100 numbers. 
 * Submit this task to an ExecutorService, retrieve the result using a Future, 
 * and print it out.
 */

public class SumOfIntegers {
	
	public static void main(String args[]) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Callable<Integer> task = ()-> {
			int sum=0;
			for(int i=0;i<=100;i++) {
				sum+=i;
			}
			return sum;
		};
		
		Future<Integer> future = executor.submit(task);
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
		
	}

}
