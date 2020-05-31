package com.huangxw.DesignPattern.iterator;

import java.util.Iterator;

public class ComputerCollege implements College {

    Department[] departments;
    int numOfDepartments = 0;    //保存当前数组的对象个数

    @Override
    public String getName() {
        return "计算机学院";
    }

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("Java专业","java");
        addDepartment("PHP专业","PHP");
        addDepartment("大数据专业","大数据");
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name,desc);
        departments[numOfDepartments] = department;
        numOfDepartments += 1;

    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
