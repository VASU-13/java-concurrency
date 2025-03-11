package com.vs.customizingexecutors.example4;


// Implement a custom ThreadFactory that names threads as "Scraper-Thread-<number>"
// Return a new thread with a meaningful name like "Scraper-Thread-<number>"

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

    private int counter = 0;

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "Scraper-Thread-" + counter++);
    }
}
