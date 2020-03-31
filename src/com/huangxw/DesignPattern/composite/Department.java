package com.huangxw.DesignPattern.composite;

public class Department extends OrganizationComponent {

    public Department(String name, String des) {
        super(name, des);
    }

    //add , remove 不用写了，因为他是叶子节点
    @Override
    protected void print() {
        System.out.println(getName());
    }
}
