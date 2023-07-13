package com.state;

public class JoinDemo01 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Vip线程"+i);
        }
    }

    public static void main(String[] args) {
        JoinDemo01 joinDemo01=new JoinDemo01();
        Thread thread=new Thread(joinDemo01);
        thread.start();

        for (int i = 0; i < 500; i++) {
            System.out.println("这是主线程"+i);
            if(i==200){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
