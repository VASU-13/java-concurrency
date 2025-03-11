package com.vs.customizingexecutors.example2;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    private int counter = 0;

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "CustomThread-" + counter++);
    }
}
