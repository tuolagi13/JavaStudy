package com.huangxw.DesignPattern.builder.improve;

//抽象的建造者
public abstract class HouseBuilder {

    public House house = new House();

    //将建造的流程写好，抽象的方法
    public abstract void buildBasic();
    public abstract void buildWall();
    public abstract void roofed();

    //建造房子,将产品(房子)返回
    public House  buildHouse(){
        return house;
    }
}
