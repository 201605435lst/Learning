package com.componey;

import org.junit.Assert;
import org.junit.Test;

public class TestHello {
    @Test
    public void TestAdd(){
        System.out.println("测试主程序");
        Hello hello=new Hello();
        int aa=hello.add(5,6);
        System.out.println(aa);
        Assert.assertEquals(11,aa);
    }
}
