package com.huangxw.DesignPattern.singleton;

/**懒汉式(线程安全,同步代码块)
 * 这种方法没有效果，其他线程还是会同时进入判断语句部分，无法起到线程安全作用
 * 结论：
 * 实际开发中，不能使用这种方式
**/
public class Singleton5 {

    //1.私有化构造器，外部不能new
    private Singleton5(){

    }

    //2.本类内部成员变量
    private  static Singleton5 instance;


    //3.加入同步代码块
    public static  Singleton5 getInstance(){
        if(null == instance){
            synchronized (Singleton5.class){
                instance = new Singleton5();
            }
        }
        return instance;
    }

    public static void main(String[] args) {

        Singleton5 singleton1 = Singleton5.getInstance();
    }
}
