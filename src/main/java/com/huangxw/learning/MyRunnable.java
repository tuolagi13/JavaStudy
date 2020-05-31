package com.huangxw.learning;

public class MyRunnable implements Runnable{

    volatile boolean pause;

    void tellToPause(){
        pause = true;
    }

    void tellToResume(){
        synchronized (this){
            this.notify();
        }
    }

    @Override
    public void run() {
        System.out.println("进入不可暂停区域1。。。。。。");
        try
        {
            Thread.sleep(500);
            System.out.println("退出不可暂停区域1。。。。。。");
            System.out.println("检测标志pause = " + String.valueOf(pause));
            if(pause)
            {
                System.out.println("暂停执行。。。。。。");
                synchronized (this) {
                    this.wait();
                }
            }
            System.out.println("恢复执行。。。。。。");
            System.out.println("进入不可暂停区域2。。。。。。");
            Thread.sleep(500);
            System.out.println("退出不可暂停区域2。。。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable my = new MyRunnable();
        new Thread(my).start();
        my.tellToPause();
        Thread.sleep(800);
        my.tellToResume();

    }
}
