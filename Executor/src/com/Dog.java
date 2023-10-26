package com;

public class Dog implements Cat{
    @Override
    public void run() {
        System.out.println("本派");
    }

    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.run();
        System.out.println(dog.name); // 也可以使用类名来访问接口中的常量name
    }
}

