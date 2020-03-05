package com.huangxw.DesignPattern.singleton;

/**饿汉式(静态代码块)
 * 也是在类装载时即初始化实例
 * 优缺点同Singleton1
**/
public class Singleton2 {

    //1.私有化构造器，外部不能new
    private Singleton2(){

    }


    //2.本类内部成员变量
    private  static Singleton2 instance;


    static {//静态代码块中创建单例对象
        instance = new Singleton2();
    }

    //3.提供一个公有的静态方法，返回对象实例
    public static Singleton2 getInstance(){

        return instance;
    }

    public static void main(String[] args) {

        Singleton2 singleton1 = Singleton2.getInstance();
    }
}
