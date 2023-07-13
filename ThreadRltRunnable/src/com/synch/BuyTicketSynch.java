package com.synch;


class BuyTicketSynch  {

    public static void main(String[] args) {
        BuyTicket2 buy = new BuyTicket2();
        new Thread(buy, "小明").start();
        new Thread(buy, "小力").start();
        new Thread(buy, "小刚").start();

    }

}

class BuyTicket2 implements Runnable {

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
//    synchronized 同步方法，锁的是this
    public synchronized void buy() {
        if (tickCount <= 0) {
            System.out.println("买票结束");
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "买到了第" + tickCount-- + "张票");
    }

}