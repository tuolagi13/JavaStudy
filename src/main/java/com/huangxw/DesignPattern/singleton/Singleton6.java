package com.huangxw.DesignPattern.singleton;

/**静态内部类
 *
 * 结论：也是很推荐的方式
**/
public class Singleton6 {

    //1.私有化构造器，外部不能new
    private Singleton6(){

    }
    //写一个静态静态内部类，里有静态属性
    //1.Singleton6被装载时，静态内部类不会被装载
    //2.方法用到静态内部类时，才会加载静态内部类，且只会装载一次
    //3.类装载时，线程是安全的
    private static class SingletonInstance {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    //2.加载静态内部类方法
    public static Singleton6 getInstance(){
        return SingletonInstance.INSTANCE;
    }

    public static void main(String[] args) {

        Singleton6 singleton1 = Singleton6.getInstance();
    }
}
