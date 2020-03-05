package com.huangxw.DesignPattern.singleton;

/**饿汉式(静态变量)
 * 优点：
 * 1.写法简单，避免线程同步问题
 * 缺点：
 * 1.类装载时就完成实例化，没有达到lazy loading的效果，如果始终未用这个实例，造成内存浪费
 * 2.这种基于了classloader机制，在类装载时就实例化。调用getInstance方法当然会触发类装载
 * 进行实例化，但是导致类装载的原因有很多，可能有其他方式导致类装载，此时初始化getInstance
 * 不能达到lazy loading的效果
**/
public class Singleton1 {

    //1.私有化构造器，外部不能new
    private Singleton1(){

    }
    //2.本类内部创建对象实例
    private final static  Singleton1 instance = new Singleton1();
    //3.提供一个公有的静态方法，返回对象实例
    public static Singleton1 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
    }
}
