package com;
public class Hello{
	public int add(int a, int b){
		return a+b;
	}
	public static void main(String args[]){
		Hello h=new Hello();
		int sum=h.add(3,4);
		System.out.println(sum);
	}
}