package com.huangxw.fifty.lambda;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class LambdaTest {
    
    @Test
    public void testClosure() throws InterruptedException {
        /*
            jdk8之前，必须final修饰str
            因为局部变量在方法中，方法调用完毕即弹出，从内存消失。
            而匿名内部类的实例是在堆中，未来某个时刻被垃圾回收。
            生命周期不同步会导致：一个实例持有一个已经不存在的变量引用
            由于对象的生命周期无法改变，只能局部变量做出让步：加final为常量，常驻内存
            这样变量的生命周期反而比实例更长。
         */
        final String str = "hello";
        
        Runnable r = () -> {
            System.out.println(str);
            System.out.println("this==>" + this);
        };
        
        new Thread(r).start();
        TimeUnit.SECONDS.sleep(1);
    }
}
