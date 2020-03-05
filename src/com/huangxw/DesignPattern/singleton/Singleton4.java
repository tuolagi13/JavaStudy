package com.huangxw.DesignPattern.singleton;

/**懒汉式(线程安全,同步方法)
 * 优点：
 * 起到了laxy loading的效果，线程安全
 * 缺点：
 * 效率太低，getInstance方法可能被调用频繁
 * 结论：
 * 实际开发中，不推荐这种方式
**/
public class Singleton4 {

    //1.私有化构造器，外部不能new
    private Singleton4(){

    }

    //2.本类内部成员变量
    private  static Singleton4 instance;


    //3.加入同步方法，解决线程不安全问题
    public static synchronized Singleton4 getInstance(){
        if(null == instance){
            instance = new Singleton4();
        }
        return instance;
    }

    public static void main(String[] args) {

        Singleton4 singleton1 = Singleton4.getInstance();
    }
}
