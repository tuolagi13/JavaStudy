package com.huangxw.DesignPattern.composite;

/**
 * 组合模式
 * 需求：
 * 学校、学院、系的展示，传统方案：学校-学院-系继承关系
 * 这种方案不能很好的进行管理操作，如学院、系的添加、删除、遍历等
 * 解决方案：
 * 组合模式
 * 把学校、学院、系看作组织结构，他们之间没有继承关系，而是一个树形结构，可以更好的实现管理操作
 * 组合模式的设计模式属于结构型模式
 * HashMap源码用到了组合模式，HashMap的静态内部类Node相当于叶子节点
 */
public class Client {

    public static void main(String[] args) {

        //从大到小，创建对象
        OrganizationComponent university = new University("清华大学","顶级大学");

        //创建学院
        OrganizationComponent computerCollege = new College("计算机学院","光明的前景");
        OrganizationComponent infoCollege = new College("信息工程学院","辉煌的未来");

        //创建各个学院下面的系
        computerCollege.add(new Department("软件工程","很不错"));
        computerCollege.add(new Department("网络工程","王牌"));
        computerCollege.add(new Department("计算机科学与技术","老牌专业"));
        infoCollege.add(new Department("通信工程","不好学"));
        infoCollege.add(new Department("信息工程","很好学"));

        university.add(computerCollege);
        university.add(infoCollege);

        //university.print();
        computerCollege.print();

    }
}
