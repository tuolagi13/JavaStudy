package com.huangxw.DesignPattern.facade;

public class DVDPlayer {

    //使用单例模式，饿汉式
    private static DVDPlayer instance= new DVDPlayer();

    public static DVDPlayer getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("DVD is on...");
    }

    public void off(){
        System.out.println("DVD is off...");
    }

    public void play(){
        System.out.println("DVD is playing...");
    }

    public void pause(){
        System.out.println("DVD is pauseing...");
    }

    //....
}
