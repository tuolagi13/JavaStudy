package com.huangxw.DesignPattern.facade;
//爆米花机
public class PopCorn {

    //使用单例模式，饿汉式
    private static PopCorn instance= new PopCorn();

    public static PopCorn getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("PopCorn is on...");
    }

    public void off(){
        System.out.println("PopCorn is off...");
    }

    public void pop(){
        System.out.println("PopCorn is poping...");
    }


    //....
}
