package com.huangxw.DesignPattern.adapter.objectadapter;

/**
 * 对象适配器模式
 * 基本思路与类适配器模式相似，只是将Adapter类做修改，不再继承src类
 * 改为持有src类的实例
 * 因为根据合成复用原则：系统中尽量使用关联关系代替继承关系
 * 对象适配器模式是适配器模式常用的一种
 *
 *
 * 最后还有一种接口适配器模式
 * 当不需要实现接口中每一个方法时，可先设计一个抽象类接口，并为
 * 接口中每个方法提供一个默认实现，那么该抽象类的子类可有选择的覆盖
 * 父类中的某些方法
 *
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}
