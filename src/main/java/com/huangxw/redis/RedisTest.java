package com.huangxw.redis;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 实现redis分布式锁
 * 1.不用redis锁，单机时可通过reentrantLock.lock()、reentrantLock.unlock()实现
 *
 * 2.自己写RedisLock类，实现redis分布式锁
 */
public class RedisTest {

    private static Integer inventory = 1001;
    private static final int NUM = 1000;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
    static RedisLock redisLock = new RedisLock();

    @Test
    public void test() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(inventory,inventory,10L, TimeUnit.SECONDS,linkedBlockingQueue);
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1000);

        for (int i = 0; i < NUM; i++)
        {
            threadPoolExecutor.execute(() -> {
                String uuid = UUID.randomUUID().toString();  //使用UUID，保证谁加的锁，谁删除
                try
                {
                    if(!redisLock.lock(uuid))
                    {
                        System.out.println("locked error！！！！！！");
                        return;
                    }
                    inventory--;
                    System.out.println(inventory);
                    countDownLatch.countDown();
                    //System.out.println("线程执行：" + Thread.currentThread().getName());
                }finally
                {
                    redisLock.unlock(uuid);
                }

            });
        }

        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("线程执行数：" + NUM + " 总耗时：" + (end - start) + " 库存数为:" + inventory);
    }

    @Test
    public void testRedission() throws InterruptedException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(inventory,inventory,10L, TimeUnit.SECONDS,linkedBlockingQueue);
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1000);

        for (int i = 0; i < NUM; i++)
        {
            threadPoolExecutor.execute(() -> {
                String uuid = UUID.randomUUID().toString();  //使用UUID，保证谁加的锁，谁删除
                RLock lock = redissonClient.getLock("lockName");
                boolean res = false;
                try
                {   // 尝试加锁，最多等待2秒，上锁以后3秒自动解锁
                    res = lock.tryLock(2,3, TimeUnit.SECONDS);
                    if(res)
                    {
                        inventory--;
                        System.out.println(inventory);
                        countDownLatch.countDown();
                    }
                }
                catch (InterruptedException e) {
                    System.out.println("加锁失败！！！！！！");
                }
                finally
                {
                    lock.unlock();
                }
            });
        }

        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("线程执行数：" + NUM + " 总耗时：" + (end - start) + " 库存数为:" + inventory);


    }
}
