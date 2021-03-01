package com.huangxw.fifty.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class ParkTest {
    
    @Test
    public void testPark() throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) 
        {
            Thread t = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ", 我开始工作了~");
                LockSupport.park(this);
                System.out.println(Thread.currentThread().getName() + ", 我又活过来了~");
            });
            t.start();
            threadList.add(t);
        }
        
        Thread.sleep( 3 * 1000L);
        System.out.println("====== 所有线程都阻塞了，3秒后全部恢复了 ======");
        
        //unPark()所有线程
        for (Thread thread : threadList)
        {
            LockSupport.unpark(thread);
        }
        //等待所有线程执行完毕
        Thread.sleep( 3 * 1000L);
        
    }
}
