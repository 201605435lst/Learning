package com.state;

public class YieldDemo01 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始运行");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"线程停止运行");
    }

    public static void main(String[] args) {
            YieldDemo01 yieldDemo01=new YieldDemo01();
            new Thread(yieldDemo01,"A").start();
            new Thread(yieldDemo01,"B").start();
    }

}
