package com.huangxw.DesignPattern.facade;
//影院灯光
public class TheaterLight {

    //使用单例模式，饿汉式
    private static TheaterLight instance= new TheaterLight();

    public static TheaterLight getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("TheaterLight is on...");
    }

    public void off(){
        System.out.println("TheaterLight is off...");
    }

    public void bright(){
        System.out.println("TheaterLight is bright...");
    }

    public void dim(){
        System.out.println("TheaterLight is dim...");
    }

    //....
}
