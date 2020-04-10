package com.huangxw.DesignPattern.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {

    List<Department> departments;   //信息工程学院以list方式存放系
    int index = -1;                 //索引

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    //判断list中还有没有下个元素
    @Override
    public boolean hasNext() {
        if(index >= departments.size() -1)
            return false;
        else{
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departments.get(index);
    }

    @Override
    public void remove() {

    }
}
