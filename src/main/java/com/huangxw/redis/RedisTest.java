package com.huangxw.redis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现redis分布式锁
 * 1.不用redis锁，单机时可通过reentrantLock.lock()、reentrantLock.unlock()实现
 */
public class RedisTest {

    private static Integer inventory = 1001;
    private static final int NUM = 1000;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(inventory,inventory,10L, TimeUnit.SECONDS,linkedBlockingQueue);
        final CountDownLatch countDownLatch = new CountDownLatch(NUM);
        long start = System.currentTimeMillis();

        for (int i = 0; i < NUM; i++)
        {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    reentrantLock.lock();
                    inventory--;
                    reentrantLock.unlock();
                    System.out.println("线程执行：" + Thread.currentThread().getName());
                    //将count值减1
                    countDownLatch.countDown();
                }
            });
        }
        threadPoolExecutor.shutdown();
        try {
            //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("线程执行数：" + NUM + " 总耗时：" + (end - start) + " 库存数为:" + inventory);
    }
}
