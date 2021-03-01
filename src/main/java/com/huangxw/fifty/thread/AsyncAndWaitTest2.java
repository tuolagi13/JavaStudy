package com.huangxw.fifty.thread;

public class AsyncAndWaitTest2 {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "主线程开始！");
        Worker worker = new Worker();
        worker.begin();
        System.out.println(Thread.currentThread().getName() + "主线程结束！");
        Thread.sleep(4 * 1000L);
    }
    
    
    static class Worker implements Runnable {
    
        /**
         * 自定义的begin方法，会开启一个新线程，把当前对象作为一个任务
         */
        public void begin() {
            new Thread(this).start();
        }
        
        @Override
        public void run() {
            System.out.println("执行Worker#run()开始！");
            try {
                Thread.sleep(3 * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行Worker#run()结束！");
        }
    }
}
