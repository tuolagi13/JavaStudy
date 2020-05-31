package com.huangxw.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟用户抢购最大并发
 */
public class RedisSecKiller {

    private static final int N_THREADS = 5;
    static final String WATCH_KEY = "Goods";          //jedis通过watch方法监控WATCH_KEY
    private static final int GOODS_NUM = 10;          //商品总量
    private static final int USER_NUM = 100;          //用户数量

    public static void main(String[] args) {
        //创建线程池，模拟N_THREADS位用户同时抢购的场景
        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
        Jedis jedis = JedisUtil.getJedis();
        //设置总商品数10
        jedis.set(WATCH_KEY, String.valueOf(GOODS_NUM));
        jedis.close();

        for (int i = 0; i < USER_NUM; i++)
        {
            executorService.execute(new JedisRunnable(UUID.randomUUID().toString()));
        }
    }
}

class JedisRunnable implements Runnable{

    private Jedis jedis = JedisUtil.getJedis();
    private String userId;

    public JedisRunnable(String userId) {
        this.userId = userId;
    }

    public void run() {
        try
        {
            //监视该key，如果事务执行前这个key被其他命令改动，事务将被打断
            jedis.watch(RedisSecKiller.WATCH_KEY);
            int leftGoodsNum = Integer.parseInt(jedis.get(RedisSecKiller.WATCH_KEY));   //获取剩余商品数
            if(leftGoodsNum > 0)
            {
                Transaction tx = jedis.multi();                     //开启事务
                tx.decrBy(RedisSecKiller.WATCH_KEY,1);
                List<Object> results = tx.exec();                   //提交事务
                //results为null或空时，表示并发情况下用户没能抢购到商品，秒杀失败
                if(results == null || results.isEmpty())
                {
                    String failUserInfo = "fail---" + this.userId;
                    String failMsg = "用户" + failUserInfo + ",抢购失败，剩余商品量：" + leftGoodsNum;
                    System.out.println(failMsg);
                    jedis.setnx(failUserInfo,failMsg);
                }
                else  //此时tx.exec()事务执行成功，会自动提交事务。
                {
                    for (Object succ:results)
                    {
                        String succUserInfo = "succ---" + userId;
                        String succMsg = "用户" + succUserInfo + ",抢购成功，剩余商品量：" + leftGoodsNum;
                        System.out.println(succMsg);
                        jedis.setnx(succUserInfo,succMsg);
                    }
                }

            }
            else //此时库存为0，秒杀结束
            {
                String overUserInfo = "over---" + userId;
                String overMsg = "用户" + overUserInfo + ",抢购失败！" ;
                System.out.println(overMsg);
                jedis.setnx(overUserInfo,overMsg);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            JedisUtil.returnResource(jedis);
        }
    }
}
