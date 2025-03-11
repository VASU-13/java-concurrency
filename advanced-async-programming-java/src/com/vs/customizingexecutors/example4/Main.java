package com.vs.customizingexecutors.example4;

import com.vs.customizingexecutors.example3.CustomRejectedExecutionHandler;
import com.vs.customizingexecutors.example3.CustomThreadFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/*
    Your task is to set up a basic multithreaded scraper that fetches content from the given 20 URLs concurrently. Each thread should handle one URL, and you will implement a custom ThreadFactory to name the threads meaningfully (e.g., "Scraper-Thread-0").

    You will also need to log any rejected tasks in CustomRejectedExecutionHandler for future reprocessing.

    This task gives you the opportunity to apply your skills to a practical scenario involving both thread management and task handling.

 */

public class Main {

    public static void main(String[] args) {
        // A list of 20 URLs to scrape
        List<String> urls = Arrays.asList(
                "http://example.com/url1", "http://example.com/url2", "http://example.com/url3",
                "http://example.com/url4", "http://example.com/url5", "http://example.com/url6",
                "http://example.com/url7", "http://example.com/url8", "http://example.com/url9",
                "http://example.com/url10", "http://example.com/url11", "http://example.com/url12",
                "http://example.com/url13", "http://example.com/url14", "http://example.com/url15",
                "http://example.com/url16", "http://example.com/url17", "http://example.com/url18",
                "http://example.com/url19", "http://example.com/url20"
        );

        // Create a ThreadPoolExecutor with a core pool size of 4, maximum pool size of 8, and work queue size of 5
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                4,
                8,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8),
                new CustomThreadFactory(),
                new CustomRejectedExecutionHandler()
        );


        // Submit tasks for each URL to the executor
        for(int i=0;i<urls.toArray().length;i++) {
            int finalI = i;
            executor.submit(()->{
                System.out.println("Fetching data from " + urls.get(finalI) + " by " + Thread.currentThread().getName());
                sleep();
            });
        }

        // Ensure proper shutdown of the executor

        executor.shutdown();
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
