package com.vs.threadpoolsexecutors;

//Implement the ApiFetcher class, which implements Runnable
//The class should have a constructor that accepts the name of the API being fetched
//Implement the run() method to print a message indicating which thread is fetching data from the API

public class ApiFetcher implements Runnable {
	
	private final String api;
	
	public ApiFetcher(String api) {
		this.api = api;
	}

	 @Override
	    public void run() {
	        System.out.println(Thread.currentThread().getName() + " fetching data from " + api);
	        try {
	            // Simulating API call delay
	            Thread.sleep((long) (Math.random() * 100));
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            System.out.println("Task interrupted: " + api);
	        }
	        System.out.println(Thread.currentThread().getName() + " completed fetching from " + api);
	    }
	
}