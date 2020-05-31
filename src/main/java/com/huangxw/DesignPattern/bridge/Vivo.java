package com.huangxw.DesignPattern.bridge;

public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("VIVO手机开机");
    }

    @Override
    public void close() {
        System.out.println("VIVO手机关机");
    }

    @Override
    public void call() {
        System.out.println("VIVO手机打电话");
    }
}
