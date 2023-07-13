package com.synch;

public class SynchDemo02 {

    public static void main(String[] args) {
        Account account=new Account(100,"结婚基金");
        Drawing drawing=new Drawing(account,50,"小王");
        Drawing drawing2=new Drawing(account,100,"小李");

        drawing.start();
        drawing2.start();
    }

}

//账户
class Account{
  //余额
  int money;
  String name;//卡名

    public Account(int money,String name){
        this.money=money;
        this.name=name;
    }
}

//银行取钱
class Drawing extends Thread{

    Account account;//账户
    int drawingMoney;//取了多少钱
    int nowMoney;//手里多少钱

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    @Override
    public void run() {
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