package com.vs.threadpoolsexecutors;
import java.util.concurrent.*;

/*
 * ScheduledExecutorService, which allows you to schedule tasks to run after a delay or periodically. 
 * This is useful for tasks that need to be delayed or run at regular intervals, 
 * such as system health checks or timed actions.
 * 
 */



public class ScheduledExecutorExample {
    public static void main(String[] args) {
        // Create a ScheduledExecutorService with a thread pool size of 2
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Schedule the first task after a 2-second delay
        scheduler.schedule(() -> {
            System.out.println("Task 1 executed by: " + Thread.currentThread().getName());
        }, 2, TimeUnit.SECONDS);

        // Schedule the second task after a 4-second delay
        scheduler.schedule(() -> {
            System.out.println("Task 2 executed by: " + Thread.currentThread().getName());
        }, 4, TimeUnit.SECONDS);

        // Shutdown the scheduler gracefully after a delay to allow tasks to complete
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("Scheduler shutdown initiated.");
        }, 6, TimeUnit.SECONDS);
    }
}
