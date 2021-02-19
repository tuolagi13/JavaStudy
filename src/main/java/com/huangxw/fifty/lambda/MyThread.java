package com.huangxw.fifty.lambda;

public class MyThread {
    
    private MyRunnable target;
    
    public MyThread() {}
    
    public MyThread(MyRunnable target) {
        this.target = target;
    }
    
    
    //MyThread自己的run() 现在基本不用了
    public void run() {
        System.out.println("去12306买了一张票");
        System.out.println("坐火车...");
    }
    
    public void start() {
        if(target != null)
            target.run();
        else
            this.run();
    }
    
    public static void main(String[] args) {
        new MyThread(() -> System.out.println("不用买票")).start();
    }
}
