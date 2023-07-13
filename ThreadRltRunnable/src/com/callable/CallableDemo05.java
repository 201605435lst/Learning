package com.callable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class CallableDemo05 implements Callable<Boolean> {
   private String url;
   private String name;

    public CallableDemo05(String url,String name ){
        this.url=url;
        this.name=name;
    }

    //实现call方法
    @Override
    public Boolean call() {
        downloader(url,name);
        System.out.println("文件名称为"+name+"下载了");
        return true;
    }

    public  void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableDemo05 t1=new CallableDemo05("https://cn.bing.com/images/search?q=%E5%9B%BE%E7%89%87&FORM=IQFRBA&id=0BDF3A3289356D51A820116655965BB18DA73F04","文件1.jpg");
        CallableDemo05 t2=new CallableDemo05("https://cn.bing.com/images/search?q=%E5%9B%BE%E7%89%87&FORM=IQFRBA&id=7EB91D937DD64C42871BEC9DFA66DE7E3E8663D8","文件2.jpg");
        CallableDemo05 t3=new CallableDemo05("https://cn.bing.com/images/search?q=%E5%9B%BE%E7%89%87&FORM=IQFRBA&id=21679CBB0E9648E00603E35CB617428F7F6FB48B","文件3.jpg");

        //1、创建执行服务
        ExecutorService executorService= Executors.newFixedThreadPool(3);

        //2、提交执行
        Future<Boolean> r1=executorService.submit(t1);
        Future<Boolean> r2=executorService.submit(t2);
        Future<Boolean> r3=executorService.submit(t3);

        //3、获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

       //4、关闭服务
        executorService.shutdownNow();
    }



}


