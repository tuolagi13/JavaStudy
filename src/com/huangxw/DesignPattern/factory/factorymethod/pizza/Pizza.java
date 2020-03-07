package com.huangxw.DesignPattern.factory.factorymethod.pizza;

public abstract class Pizza {
    protected String name;

    //不同种类pizza准备材料不同
    public abstract void prepare();

    //烘培
    public void bake(){
        System.out.println(name + " baking;");
    }
    //分块
    public void cut(){
        System.out.println(name + " cutting;");
    }
    //装箱
    public void box(){
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}
