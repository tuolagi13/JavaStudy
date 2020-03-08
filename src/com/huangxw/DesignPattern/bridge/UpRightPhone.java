package com.huangxw.DesignPattern.bridge;

//翻盖式手机类，继承抽象类
public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    public void open(){
        super.open();
        System.out.println("直立手机开机");
    }

    public void close(){
        super.close();
        System.out.println("直立手机关机");
    }

    public void call(){
        super.call();
        System.out.println("直立手机打电话");
    }
}
