package com.huangxw.DesignPattern.decorator;

public class Decorator extends Drink{

    private Drink obj;

    public Decorator(Drink obj) {//组合
        this.obj = obj;
    }

    //getPrice：调料自己的价格； obj.cost()：咖啡的价格
    @Override
    public float cost() {
        return super.getPrice() + obj.cost();
    }

    //描述信息
    @Override
    public String getDes() {
        //obj.getDes()输出被装饰者的信息
        return super.des + " " + super.getPrice() + " && " + obj.getDes();
    }
}
