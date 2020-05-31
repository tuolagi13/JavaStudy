package com.huangxw.DesignPattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College {

    List<Department> departments;

    public InfoCollege() {
        departments = new ArrayList<Department>();
        addDepartment("信息安全专业","A");
        addDepartment("网络安全专业","B");
        addDepartment("人身安全专业","C");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name,desc);
        departments.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departments);
    }
}
