package MultiThreadedExplanation.Demo;

public class MyThread extends Thread {
    @Override
    public void run() {
       for(int i=0;i<100;i++){
        System.out.println("这是run方法"+i);
       }
    }

    public static void main(String [] args){

        MyThread myThread=new MyThread();
        myThread.start();

        for(int i=1;i<1000;i++){
            System.out.println("这是main方法"+i);
        }
    }

}