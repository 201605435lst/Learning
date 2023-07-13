package com.runnable;

public class RunnableDemo03 implements Runnable {
    @Override
    //run方法线程体
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("这是run方法" + i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        RunnableDemo03 runnableDemo03 = new RunnableDemo03();


        Thread thread = new Thread(runnableDemo03);
        thread.setDaemon(true);//默认是false,表示是用户线程，正常的线程都是用户线程...
        thread.start();
        //创建线程对象，通过线程对象来开启我们的线程代理
        thread.setPriority(1);
        thread.getPriority();
        for (int i = 1; i < 100; i++) {
            System.out.println("这是main方法" + i);
        }
    }

}
