package com.huangxw.DesignPattern.proxy.cglibproxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class Client {

    public static void main(String[] args) {
        //代理类class文件存入本地磁盘方便查看反编译源码
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\");

        //通过cglib动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        //设置Enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        //设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        //创建代理对象
        HelloService proxy = (HelloService) enhancer.create();
        proxy.sayHello();
        proxy.sayOthers("haha");
    }
}
