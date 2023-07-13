package com.state;

public class StopDemo01 implements Runnable{

    boolean flag=true;

    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("当前计数是"+i++);
        }
    }

    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        StopDemo01 stopDemo01=new StopDemo01();
        Thread thread=new Thread(stopDemo01);
        thread.start();

        for(int j=1;j<=100000;j++){
//            System.out.println("当前main方法"+j);
            if(j==90000){
                stopDemo01.stop();
//                System.out.println("线程停止了");
            }
        }

    }
}
