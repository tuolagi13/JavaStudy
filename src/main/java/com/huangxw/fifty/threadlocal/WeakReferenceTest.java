package com.huangxw.fifty.threadlocal;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car("bmw");
        //用WeakReference包装Car对象
        WeakReference<Car> weakCar = new WeakReference<>(car);
        //可以通过weakCar获取引用
        System.gc();
        System.out.println("强引用存在时:========>" + weakCar.get());
        
        //切断原始引用，那么此时只有弱引用关系，GC线程一旦发现就会回收Car对象
        car = null;
        Thread.sleep(3 * 1000L);
        System.out.println("只剩弱引用但还未GC时:========>" + weakCar.get());
        
        //主动GC
        System.gc();
        System.out.println("只剩弱引用且GC后:========>" + weakCar.get());
    
    
    }
    
    static class Car {
        private String name;
        public Car(String name) {
            this.name = name;
        }
    }
}
