package com.synch;


public class SynchDemo01 {

    public static void main(String[] args) {
        BuyTicket buy = new BuyTicket();
        new Thread(buy, "小明").start();
        new Thread(buy, "小力").start();
        new Thread(buy, "小刚").start();
        
    }

}

class BuyTicket implements Runnable {

    //总票数
    int tickCount = 10;
    boolean flag = true;

    @Override
    public void run() {

        while (flag) {
            buy();
        }

    }

    //停止买票的条件
    public void buy() {
        if (tickCount <= 0) {
            System.out.println("买票结束");
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "买到了第" + tickCount-- + "张票");

    }

}