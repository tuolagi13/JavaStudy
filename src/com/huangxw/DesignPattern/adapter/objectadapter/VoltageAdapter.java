package com.huangxw.DesignPattern.adapter.objectadapter;

//适配器
public class VoltageAdapter implements Voltage5V {

    //通过构造器，传入一个Voltage220V实例
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if(null != this.voltage220V){
            //获取220电压
            int src = voltage220V.output220V();
            System.out.println("使用对象适配器模式，进行适配~~~");
            dst = src/44;
        }
        return dst;
    }
}
