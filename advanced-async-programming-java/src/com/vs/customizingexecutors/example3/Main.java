package com.vs.customizingexecutors.example3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    private static int rejectedTaskCount = 0;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // core pool size
                4, // maximum pool size
                10, // keep-alive time
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8), // increased work queue size
                new CustomThreadFactory(),
                new CustomRejectedExecutionHandler()
        );

        // Submitting tasks
        for (int i = 1; i <= 15; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
                sleep();
            });
        }

        // Monitoring executor
        System.out.println("Active Threads: " + executor.getActiveCount());
        System.out.println("Task Count: " + executor.getTaskCount());

        logThreadPoolStats(executor); // Log stats before shutting down
        executor.shutdown();
    }


    static synchronized void incrementRejectedTaskCount() {
        rejectedTaskCount++;
    }

    private static void logThreadPoolStats(ThreadPoolExecutor executor) {
        System.out.println("Active Threads: " + executor.getActiveCount());
        System.out.println("Idle Threads: " + (executor.getPoolSize() - executor.getActiveCount()));
        System.out.println("Completed Tasks: " + executor.getCompletedTaskCount());
        System.out.println("Rejected Tasks: " + rejectedTaskCount);
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
