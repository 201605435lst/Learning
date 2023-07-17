package com;

import java.util.concurrent.*;

public class Demo01 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                4, // corePoolSize - the number of threads to keep in the pool, even if they are idle
                5, // maximumPoolSize - the maximum number of threads to allow in the pool
                10, TimeUnit.MICROSECONDS, // keepAliveTime - how long idle threads are kept alive
                new ArrayBlockingQueue<>(1), // workQueue - the queue to hold tasks waiting to be executed
                new ThreadFactory() { // threadFactory - factory to create new threads
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r); // create a new thread with name "t"
                        thread.setName("111111"); // set the thread name to "111111"
                        System.out.println("我哦么33");
                        return thread; // return the created thread
                    }
                }
        );


        executor.execute(() -> System.out.println("我哦么11")); // execute the task
        executor.execute(() -> System.out.println("我哦么22")); // execute the task

        executor.shutdown(); // 关闭线程池
    }
}
