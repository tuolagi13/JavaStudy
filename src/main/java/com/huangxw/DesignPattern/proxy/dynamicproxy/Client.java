package com.huangxw.DesignPattern.proxy.dynamicproxy;

/**
 * 动态代理
 * 1.代理对象不需要实现接口了，但是目标对象还是要实现接口，否则不能用动态代理
 * 2.代理对象的生成，是利用JDK的API,动态的在内存中构建代理对象
 * 动态代理也叫：JDK代理、接口代理
 */
public class Client {

    public static void main(String[] args) {
        //创建目标对象
        ITeacherDao target = new TeacherDao();

        //给目标对象创建代理对象,可以转成ITeacherDao
        ITeacherDao proxyInstance = (ITeacherDao)new ProxyFactory(target).getProxyInstance(target);

        System.out.println("proxyInstance = " + proxyInstance);

        proxyInstance.teach();
        proxyInstance.sayHello("Tom");

    }
}
