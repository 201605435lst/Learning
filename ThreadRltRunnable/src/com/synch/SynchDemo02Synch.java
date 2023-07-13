package com.synch;

public class SynchDemo02Synch {

    public static void main(String[] args) {
        Account1 account=new Account1(100,"结婚基金");
        Drawing1 drawing=new Drawing1(account,50,"小王");
        Drawing1 drawing2=new Drawing1(account,100,"小李");

        drawing.start();
        drawing2.start();
    }

}

//账户
class Account1{
  //余额
  int money;
  String name;//卡名

    public Account1(int money,String name){
        this.money=money;
        this.name=name;
    }
}

//银行取钱
class Drawing1 extends Thread{

    Account1 account;//账户
    int drawingMoney;//取了多少钱
    int nowMoney;//手里多少钱

    public Drawing1(Account1 account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    @Override
    public void run() {

        //锁的对象是变化的量，需要增删改的量
         synchronized (account){
             //判断有没有钱
             if(account.money<drawingMoney){
                 System.out.println("余额不足"+Thread.currentThread().getName()+"取不了");
                 return;
             }else{
                 nowMoney=nowMoney+drawingMoney;
                 System.out.println(Thread.currentThread().getName()+"手里的钱有"+nowMoney);
                 account.money=account.money-drawingMoney;
                 System.out.println(account.name+"账户的余额为"+account.money);
             }
         }
    }
}