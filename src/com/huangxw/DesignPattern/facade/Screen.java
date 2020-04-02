package com.huangxw.DesignPattern.facade;
//屏幕
public class Screen {

    //使用单例模式，饿汉式
    private static Screen instance= new Screen();

    public static Screen getInstance(){
        return instance;
    }

    public void up(){
        System.out.println("Screen is up...");
    }

    public void down(){
        System.out.println("Screen is down...");
    }



    //....
}
