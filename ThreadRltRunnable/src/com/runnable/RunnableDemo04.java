package com.runnable;

//发现问题，多个资源操作同一个资源的情况下，数据紊乱，不安全
public class RunnableDemo04 implements Runnable {

    int ticketNum = 15;

    @Override
    public void run() {
        while (true) {

            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticketNum < 0) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + "拿到了票,当前是第" + ticketNum-- + "张票");
        }
    }

    public static void main(String[] args) {
        RunnableDemo04 runnableDemo1 = new RunnableDemo04();
        new Thread(runnableDemo1, "小明").start();
        new Thread(runnableDemo1, "小丽").start();
        new Thread(runnableDemo1, "小王").start();

    }

}
