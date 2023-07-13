package com;

public class Run implements Runnable {

    private static String winerName;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {

            boolean flag = isWin(i);

            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                   // 延迟10毫秒
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "当前跑了" + i + "步");
            if (flag) {
                break;
            }
        }
    }

    //赢的规则
    public boolean isWin(int i) {
        if (winerName != null) {
            return true;
        }
        {
            if (i >= 100) {
                winerName = Thread.currentThread().getName();
                System.out.println("获胜者是" + winerName);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Run run = new Run();
        new Thread(run, "乌龟").start();
        new Thread(run, "兔子").start();
    }

}
