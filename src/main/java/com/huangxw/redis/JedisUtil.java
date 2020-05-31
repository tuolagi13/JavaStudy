package com.huangxw.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

    private static final String ADDR = "Redis_IP";
    private static final int PORT = 6379;                    //Redis的端口号
    private static final boolean TEST_ON_BORROW = true;      //在borrow一个jedis实例时，是否提前进行validate操作,如果为true，则得到的jedis实例均是可用的
    private static final int MAX_IDLE = 200;                 //控制一个pool最多有多少个状态为idle(空闲的)
    private static JedisPool jedisPool = null;


    /**
     *初始化Jedis连接池
     */
    static
    {
        try
        {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(MAX_IDLE);                        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config,ADDR,PORT);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取Jedis实例
     */
    public synchronized static Jedis getJedis(){
        try
        {
            if(jedisPool != null)
            {
                Jedis resource = jedisPool.getResource();
                return resource;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放jedis资源
     */
    public static void returnResource(final Jedis jedis){
        if(jedis !=null){
            jedis.close();
        }
    }
}
