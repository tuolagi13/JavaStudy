package com.huangxw.DesignPattern.bridge;

//折叠式手机类，继承抽象类
public class FoldedPhone extends Phone {

    public FoldedPhone(Brand brand) {
        super(brand);
    }

    public void open(){
        super.open();
        System.out.println("折叠手机开机");
    }

    public void close(){
        super.close();
        System.out.println("折叠手机关机");
    }

    public void call(){
        super.call();
        System.out.println("折叠手机打电话");
    }
}
