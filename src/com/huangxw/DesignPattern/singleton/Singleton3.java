package com.huangxw.DesignPattern.singleton;

/**懒汉式(线程不安全)
 * 优点：
 * 起到了laxy loading的效果，但是只能在单线程下使用
 * 缺点：
 * 如果在多线程下，一个线程进入 if(null == instance) 代码块，还未来得及往下执行，
 * 另一个线程也通过了这个判断语句，这是会产生多个实例，因此非线程安全
 * 结论：
 * 实际开发中，不要使用这种方式
**/
public class Singleton3 {

    //1.私有化构造器，外部不能new
    private Singleton3(){

    }

    //2.本类内部成员变量
    private  static Singleton3 instance;


    //3.提供一个公有的静态方法，当使用到该方法时，才去创建instance
    //即懒汉式
    public static Singleton3 getInstance(){
        if(null == instance){
            instance = new Singleton3();
        }
        return instance;
    }

    public static void main(String[] args) {

        Singleton3 singleton1 = Singleton3.getInstance();
    }
}
