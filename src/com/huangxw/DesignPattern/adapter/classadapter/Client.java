package com.huangxw.DesignPattern.adapter.classadapter;

/**
 * 类适配器模式
 * 假设场景：手机只能用5V电压充电，插座的电压为220V，需要通过一个适配器类将220V转为5V
 * 思路：
 * Adapter类继承src类(插座电压)，实现dst接口(转5V)
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
