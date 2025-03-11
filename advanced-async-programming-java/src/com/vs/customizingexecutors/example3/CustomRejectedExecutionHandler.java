package com.vs.customizingexecutors.example3;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import static com.vs.customizingexecutors.example3.Main.incrementRejectedTaskCount;

public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected: " + r.toString());
        incrementRejectedTaskCount();
    }
}
