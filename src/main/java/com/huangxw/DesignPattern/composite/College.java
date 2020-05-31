package com.huangxw.DesignPattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * College(院系)
 */
public class College extends OrganizationComponent {
    //代表专业
    List<OrganizationComponent> organizationComponentList = new ArrayList<OrganizationComponent>();

    public College(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        //将来实际业务中，College的add方法和 University的add方法不一样相同
        organizationComponentList.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        //将来实际业务中，College的add方法和 University的add方法不一样相同
        organizationComponentList.remove(organizationComponent);
    }

    @Override
    protected void print() {
        System.out.println("---------------" + getName() + "---------------");
        //遍历专业
        for (OrganizationComponent organizationComponent :organizationComponentList) {
            organizationComponent.print();
        }
    }
}
