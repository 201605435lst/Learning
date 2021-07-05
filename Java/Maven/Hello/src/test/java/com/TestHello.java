package com;
import org.junit.Assert;
import org.junit.Test;
public class TestHello{
    @Test
    public void TestAdd(){
        System.out.println("sdihviddddddddddddu");
        Hello h=new Hello();
        int res=h.add(10,20);
        Assert.assertEquals(30,res);
    }
}
