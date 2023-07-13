package com.state;

public class SleepDemo01 {

    public static void tenDown() throws InterruptedException {
        int i=10;
        while (true){
            System.out.println("当前计数是"+i--);
            Thread.sleep(1000);
            if(i==0){
                break;
            }
        }
    }


    //模拟倒计时
    public static void main(String[] args)  {
        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
