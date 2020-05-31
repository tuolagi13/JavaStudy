package com.huangxw.DesignPattern.builder.improve;

public class Client {
    public static void main(String[] args) {

        CommonHouse commonHouse = new CommonHouse();
        //准备创建房子的指挥者
        HouseDirector director = new HouseDirector(commonHouse);
        //完成盖房子，返回产品(房子)
        director.constructHouse();
    }
}
