package com.huangxw.DesignPattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    //维护一个目标对象，Object
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象生成一个代理对象
    public Object getProxyInstance(final Object target){

        /**
         *     public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         * 1.loader：指定当前目标对象使用的类加载器，获取加载器的方法是固定的
         * 2.interfaces：目标对象实现的接口类型，使用泛型方法确认类型
         * 3.InvocationHandler h：事件处理，会把当前目标对象方法作为参数传入
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理开始~~~");
                        //反射机制调用目标对象的方法
                        Object returnVal = method.invoke(target,args);
                        System.out.println("JDK代理提交~~~");
                        return returnVal;
                    }
                });
    }
}
