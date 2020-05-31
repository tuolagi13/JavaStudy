package com.huangxw.DesignPattern.adapter.classadapter;

//适配器
public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        //获取220电压
        int src = output220V();
        int dst = src/44;
        return dst;
    }
}
