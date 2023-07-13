package com.state;

public class StateDemo01 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("循环体结束");

        });

        //观测状态
        Thread.State state = thread.getState();
        System.out.println(state);//NEW

        //启动
        thread.start();

        state = thread.getState();
        System.out.println(state);//RUNNABLE

        while (state!=Thread.State.TERMINATED){
            state = thread.getState();
            System.out.println(state);
        }

    }

}
