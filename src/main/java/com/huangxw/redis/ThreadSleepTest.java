package com.huangxw.redis;

import java.util.Date;

public class ThreadSleepTest {
    private static final Object obj = new Object();

    public static void main(String[] args) {
        Date a = new Date();
        System.out.println(a);

        Thread t1 = new Thread(new MyThread1());
        Thread t2 = new Thread(new MyThread2());
        t1.start();
        t2.start();
    }

    static class MyThread1 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("thread1 start");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 end");
            }
        }
    }

    static class MyThread2 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("thread2 start");
                System.out.println("thread2 end");
            }
        }
    }
}
