package com.componey;

public class Hello {
    public int add(int a,int b){
        return a + b;
    }

    public static void main(String[] args) {
        Hello hello=new Hello();
        int aa=hello.add(4,5);
        System.out.println("hello中方法的使用");
        System.out.println(aa);
    }
}
