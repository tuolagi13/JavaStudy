package com.huangxw.DesignPattern.builder.improve;

//指挥者，这里去指定制作流程，返回产品
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    //通过构造器传入HouseBuilder

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //通过set方法传入HouseBuilder

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //如何建造房子的流程，交给指挥者
    public House  constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWall();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
