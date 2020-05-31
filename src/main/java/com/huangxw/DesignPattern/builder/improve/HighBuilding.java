package com.huangxw.DesignPattern.builder.improve;

public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println(" 高楼的地基打100米 ");
    }

    @Override
    public void buildWall() {
        System.out.println("高楼的砌墙20cm ");
    }

    @Override
    public void roofed() {
        System.out.println(" 高楼的透明屋顶 ");
    }
}
