package com.huangxw.DesignPattern.proxy.cglibproxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 自定义MethodInterceptor
 */
public class MyMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param sub         cglib生成的代理对象
     * @param method      被代理的对象方法
     * @param objects     方法入参
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("插入前置通知=========");
        Object object = methodProxy.invokeSuper(sub,objects);
        System.out.println("插入后置通知=========");
        return object;
    }
}
