package com.gaoji;


import java.util.ArrayList;
import java.util.List;

//生产者、消费者、产品、缓冲区
public class TestPc {
    public static void main(String[] args) {
        SynContainer synContainer=new SynContainer();

        Productor productor=new Productor(synContainer);
        Consumer consumer=new Consumer(synContainer);
        productor.start();
        consumer.start();
    }


}

//生产者
class Productor extends Thread{
    SynContainer synContainer;
    public Productor(SynContainer synContainer){
        this.synContainer=synContainer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
        
    }
}

//消费者
class Consumer extends Thread{

    SynContainer synContainer;
    public Consumer(SynContainer synContainer){
        this.synContainer=synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+synContainer.pop().id+"只鸡");
        }
    }
}

//产品
class Chicken{
    int id;
    Chicken(int id){
        this.id=id;
    }
}

//缓冲区
class SynContainer{

    Chicken[] chickens=new Chicken[10];

    int count=0;

    //生产者生产产品
    public synchronized  void push(Chicken chicken){

        if(count==chickens.length){
            //通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //加入产品
        chickens[count]=chicken;
        count++;

        //通知消费者可以消费了
        this.notify();

    }

    //消费者消费产品
    public synchronized Chicken pop(){
        if(count==0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果可以消费
        count--;

        //通知消费者可以消费了
        this.notify();

        return chickens[count];

    }



}