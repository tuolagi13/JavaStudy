package com.huangxw.DesignPattern.decorator;

//具体的Decorator，这里就是调味品
public class Chocolate extends Decorator {

    public Chocolate(Drink obj) {
        super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0f);         //当前调味品价格
    }
}
