package com.vs.customizingexecutors.example4;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;


// Custom Rejected Execution Handler
public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // Implement logic to log rejected tasks for future reprocessing
        System.out.println("To process later " + r.toString());

    }
}