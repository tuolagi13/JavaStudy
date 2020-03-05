package com.huangxw.DesignPattern.singleton;

/**双重检查Double-Check
 * 结论：
 * 实际开发中，推荐使用这种方式
**/
public class SingletonFinal {

    //1.私有化构造器，外部不能new
    private SingletonFinal(){

    }
    //2.本类内部成员变量,volatile可看作轻量级的synchronized,多线程下保证变量的可见性
    private  static volatile SingletonFinal instance;


    //3.加入双重检查代码，解决线程安全问题，同时保证效率
    public static SingletonFinal getInstance(){
        if(null == instance){
            synchronized (SingletonFinal.class){
                if(null == instance){
                    instance = new SingletonFinal();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

        SingletonFinal singleton1 = SingletonFinal.getInstance();
    }
}
