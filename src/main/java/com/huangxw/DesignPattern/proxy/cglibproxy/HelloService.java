package com.huangxw.DesignPattern.proxy.cglibproxy;

public class HelloService {

    public HelloService(){
        System.out.println("HelloService构建");
    }

    /**
     * 该方法不会被子类覆盖，cglib是无法代理final修饰的方法的
     */
    final public String sayOthers(String name){
        System.out.println("HelloService::sayOthers>>" + name);
        return null;
    }

    public void sayHello() {
        System.out.println("HelloServicd::sayHello");
    }


}
