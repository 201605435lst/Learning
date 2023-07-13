package com.lock;

import com.Run;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo01 {

    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"小张").start();
        new Thread(ticket,"小丽").start();
        new Thread(ticket,"小王").start();


    }

}

class Ticket implements Runnable{
    int tickNum=10;

   //定义Lock锁
   private final ReentrantLock reentrantLock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            if(tickNum<=0){
                System.out.println("当前票数为"+tickNum);
                return;
            }else{

                try{
                    //加锁
                    reentrantLock.lock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"拿到第"+tickNum--+"张票");
                }finally {
                    //解锁
                    reentrantLock.unlock();
                }


            }
        }
    }
}