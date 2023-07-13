package com;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThreadDemo02 extends Thread {
   private String url;
   private String name;

    public ThreadDemo02(String url,String name ){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader=new WebDownLoader();
        webDownLoader.downloader(url,name);
        System.out.println("文件名称为"+name+"下载了");
    }

    public static void main(String[] args) {

        ThreadDemo02 t1=new ThreadDemo02("https://cn.bing.com/images/search?q=%E5%9B%BE%E7%89%87&FORM=IQFRBA&id=0BDF3A3289356D51A820116655965BB18DA73F04","文件1.jpg");
        ThreadDemo02 t2=new ThreadDemo02("https://cn.bing.com/images/search?q=%E5%9B%BE%E7%89%87&FORM=IQFRBA&id=7EB91D937DD64C42871BEC9DFA66DE7E3E8663D8","文件2.jpg");
        ThreadDemo02 t3=new ThreadDemo02("https://cn.bing.com/images/search?q=%E5%9B%BE%E7%89%87&FORM=IQFRBA&id=21679CBB0E9648E00603E35CB617428F7F6FB48B","文件3.jpg");
        t1.start();
        t2.start();
        t3.start();
    }



}

//写一个文件下载方法
class WebDownLoader{
    public  void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
