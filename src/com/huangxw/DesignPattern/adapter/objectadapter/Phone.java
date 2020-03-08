package com.huangxw.DesignPattern.adapter.objectadapter;

public class Phone {

    //充电
    public void charging(Voltage5V voltage5V){
        if(voltage5V.output5V() == 5){
            System.out.println("电压为5V，可以充电~~~");
        }else {
            System.out.println("电压不为5V，不能充电~~~");
        }
    }
}
