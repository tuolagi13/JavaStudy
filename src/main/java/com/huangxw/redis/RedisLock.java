package com.huangxw.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/**
 * 单个服务去访问Redis的时候，redis本身单线程，不用考虑现场安全
 * 但多个服务访问redis时，如秒杀场景，几个服务同时访问redis，会产生超卖问题
 *
 * redis分布式锁实现
 */
public class RedisLock {
    private static final int NUM = 1000;

    private String LOCK_KEY = "redis_lock"; //锁键

    protected long INTERNAL_LOCK_LEAST_TIME = 2000; //锁过期时间  2s

    private long timeout = 200000;  //获取锁的超时时间, 20s

    private SetParams params = SetParams.setParams().nx().px(INTERNAL_LOCK_LEAST_TIME);

    JedisPool jedisPool = new JedisPool("127.0.0.1",6379);


    /**
     *加锁
     */
    public boolean lock(String id){
        Long start = System.currentTimeMillis();
        Jedis jedis = jedisPool.getResource();
        try
        {
            for (; ;)
            {
                //SET命令返回ok，则证明获取锁成功
                String lock = jedis.set(LOCK_KEY,id,params);
                if("OK".equals(lock))
                {
                    System.out.println("UUID: " + id + "加锁成功！！！！！！！！！");
                    return true;
                }

                try
                {
                    Thread.sleep(20);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //System.out.println("UUID: " + id + "加锁失败，等待加锁！！！！！！！！！");
                //否则循环等待，在timeout时间内仍未获取到锁，则获取失败
                long l = System.currentTimeMillis() - start;
                if(l > timeout)
                {
                    System.out.println("UUID: " + id + "等待加锁超时！！！！！！！！！");
                    return false;
                }
                else
                {
                    //System.out.println("UUID: " + id + "等待时间：" + l);
                }
            }
        }
        finally
        {
            jedis.close();
        }
    }

    //解锁
    public boolean unlock(String id){
        Jedis jedis = jedisPool.getResource();
        //lua脚本保证原子操作
        String script =
                "if redis.call('get',KEYS[1]) == ARGV[1] then " +
                    "return redis.call('del',KEYS[1])" +
                "else \n" +
                    "return 0 \n" +
                "end";

        try
        {
            //Collections.singletonList(LOCK_KEY)用于只有一个元素的list优化，减少内存分配
            Object result = jedis.eval(script,Collections.singletonList(LOCK_KEY),Collections.singletonList(id));
            if("1".equals(result.toString()))
            {
                System.out.println("UUID: " + id + "解锁成功");
                return true;
            }
            else
            {
                //System.out.println("UUID: " + id + "解锁失败！！！！！！！！！");
                return false;
            }
        }
        finally
        {
            jedis.close();
        }
    }

}
