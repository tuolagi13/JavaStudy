package com.huangxw.DesignPattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * University(学校)就是Composite，可以管理College(院系)
 */
public class University extends OrganizationComponent {
    //代表院系
    List<OrganizationComponent> organizationComponentList = new ArrayList<OrganizationComponent>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponentList.remove(organizationComponent);
    }

    @Override
    protected void print() {
        System.out.println("---------------" + getName() + "---------------");
        //遍历院系
        for (OrganizationComponent organizationComponent :organizationComponentList) {
            organizationComponent.print();
        }
    }
}
