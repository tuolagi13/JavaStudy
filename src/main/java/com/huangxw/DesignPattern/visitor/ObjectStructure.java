package com.huangxw.DesignPattern.visitor;

import java.util.LinkedList;
import java.util.List;

public class ObjectStructure {

    //维护了一个集合,管理很多人，Man或Woman
    private List<Person> personList = new LinkedList<Person>();

    //增加
    public void attach(Person person){
        personList.add(person);
    }

    //移除
    public void detach(Person person){
        personList.remove(person);
    }

    //显示测评情况
    public void display(Action action){
        for (Person p: personList) {
            p.accept(action);
        }
    }
}
