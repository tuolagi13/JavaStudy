package com.huangxw.fifty.thread;

import com.huangxw.fifty.threadlocal.ThreadLocalMap;

import java.util.concurrent.*;

public class AsyncAndWaitTest4 {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //1.主线程开启异步线程处理耗时任务，同时返回FutureTask
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> futureTask = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "=========>正在维护");
            Thread.sleep( 3 * 1000L);
            return "success";
        });
        
        //2.主线程也不闲着，继续往下执行自己的任务
        Thread.sleep(1000L);
        
        //3.尝试获取异步线程结果
        if(futureTask.isDone())
            System.out.println("异步线程结束了，获取结果：" + futureTask.get());
        else
            System.out.println("异步线程尚未结束，稍后再试！");
        
        //4.继续干活
        Thread.sleep(3000L);
        
        //5.获取异步结果
        if(futureTask.isDone())
            System.out.println("异步线程结束了，获取结果：" + futureTask.get());
        else
            System.out.println("异步线程尚未结束，稍后再试！");
        
        executorService.shutdown();
        //当然这种做法也不是很优雅，JDK1.8提供了CompleteableFuture，后面学习
    }
    
    
   
}
