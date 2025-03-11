package com.vs.customizingexecutors.example2;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
        LinkedBlockingQueue for unlimited capacity. LinkedBlockingQueue differs from ArrayBlockingQueue in
        that it offers unlimited capacity,
        whereas ArrayBlockingQueue has a fixed size.

 */

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3, // core pool size
                6, // maximum pool size
                10, // keep-alive time
                TimeUnit.SECONDS,
                new LinkedTransferQueue<>(), // increased work queue size
                new CustomThreadFactory(),
                new CustomRejectedExecutionHandler()
        );

        // Submitting tasks
        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
                sleep();
            });
        }

        // Monitoring executor
        System.out.println("Active Threads: " + executor.getActiveCount());
        System.out.println("Task Count: " + executor.getTaskCount());

        executor.shutdown();
    }

    private static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
