package com;

public class LambdaDemo06 {

    //3、静态内部类
    static class Person2 implements RunSports {
        @Override
        public void run() {
            System.out.println("静态内部类");
        }
    }

    public static void main(String[] args) {

        //4、局部内部类
        class Person3 implements RunSports {
            @Override
            public void run() {
                System.out.println("局部内部类");
            }
        }



        RunSports person1 = new Person1();
        person1.run();

        person1 = new Person2();
        person1.run();


        person1 = new Person3();
        person1.run();

        //5、匿名内部类
        person1=new RunSports(){
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        };
        person1.run();


        //6、用lambDa简化
        person1=()->{
                System.out.println("匿名内部类");
        };
        person1.run();


    }
}

/*1、 定义一个函数式接口 */
interface RunSports {
    void run();
}

//2、实现类
class Person1 implements RunSports {
    @Override
    public void run() {
        System.out.println("这是实现类");
    }
}
