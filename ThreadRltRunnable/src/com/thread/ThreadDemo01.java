package com.thread;

public class ThreadDemo01 extends Thread {

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("这是run方法"+i);
        }
    }

    public static void main(String [] args){

        ThreadDemo01 myThread=new ThreadDemo01();
        myThread.start();

        for(int i=1;i<1000;i++){
            System.out.println("这是main方法"+i);
        }
    }
}
