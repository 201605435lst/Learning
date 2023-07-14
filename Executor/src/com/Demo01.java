package com;

import java.util.concurrent.*;

public class Demo01 {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);

        ThreadPoolExecutor executor=new ThreadPoolExecutor(2, 4, 10, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(2), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread("t");
                thread.setName("111111");
                return thread;
            }
        });

//        executor.execute();

    }
}
