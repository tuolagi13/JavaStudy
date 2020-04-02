package com.huangxw.DesignPattern.facade;
//立体声
public class Stereo {

    //使用单例模式，饿汉式
    private static Stereo instance= new Stereo();

    public static Stereo getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("Stereo is on...");
    }

    public void off(){
        System.out.println("Stereo is off...");
    }

    public void up(){
        System.out.println("Stereo is up...");
    }

    public void down(){
        System.out.println("Stereo is down...");
    }

    //....
}
