package com.huangxw.fifty.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AsyncAndWaitTest3 {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //FutureTask实现了Runnable，可以看作一个任务
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "========》正在执行！");
                Thread.sleep(3 * 1000L);
                return "success";
            }
        });
        System.out.println(Thread.currentThread().getName() + "========》启动任务！");
        
        //传入FutureTask，启动线程执行任务
        new Thread(futureTask).start();
        //但它同时又实现了Future，可以获取异步结果(会阻塞3秒)
        String result = futureTask.get();
        System.out.println("任务执行结束，result========>" + result);
        
    }
    
    
   
}
