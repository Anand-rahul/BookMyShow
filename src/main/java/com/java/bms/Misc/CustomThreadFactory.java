package com.java.bms.Misc;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class CustomThreadFactory implements ThreadFactory {
    private final String prefix;
    private final AtomicInteger threadCount = new AtomicInteger(1);

    public CustomThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(prefix + threadCount.getAndIncrement());
        thread.setDaemon(false);
        return thread;
    }
}
