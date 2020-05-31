package com.huangxw.learning;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable{

    //SimpleDateFormat不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    @Override
    public void run() {
        System.out.println("Thread Name = " + Thread.currentThread().getName() + "default Formatter = " + formatter.get().toPattern());

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter样式在此处更改了，但其他线程不会感知
        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name = " + Thread.currentThread().getName() + "Formatter = " + formatter.get().toPattern());

    }

    public static void main(String[] args) throws InterruptedException{

        ThreadLocalExample obj = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj,"" + i);
            //阻塞main线程
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }

    }

    public void testType() {
        if (isType(1)) {
            System.out.println("Type");
        } else {
            System.out.println("Not type");
        }
    }
    public boolean isType(int type) {
        if (type == 1) {
            return false;
        }
        return true;
    }
}
