package com.huangxw.DesignPattern.builder;

/**
 * 普通方法盖房子
 * 缺点：
 * 把产品(房子)和创建过程(建房子流程)封装在一起，耦合性增强了
 * 解决方案：
 * 产品和产品建造过程解耦，即建造者模式
 */
public class Client {
    public static void main(String[] args) {
        CommonHouse house = new CommonHouse();
        house.build();
    }
}
