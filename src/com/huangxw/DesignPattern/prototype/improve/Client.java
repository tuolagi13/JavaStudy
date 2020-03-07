package com.huangxw.DesignPattern.prototype.improve;



/**
 * 原型模式
 * 用原型实例指向创建对象的种类，并且通过拷贝这些原型，创建新的对象
 * 原型模式是一种创建型设计模式
 * 原型对象改变后，克隆生成的会动态变化
 *
 * 浅拷贝问题：
 * 浅拷贝仅复制基本类型和字符串
 * 如果Sheep类成员中有另一个对象(如Sheep friend)，使用默认的clone方法时，
 * 克隆的所有对象friend的hashcode值一致，即它们没有真正被复制，只是friend
 * 的引用指向原型对象的friend
 *
 * 深拷贝：
 * 不仅复制对象所有基本数据类型与字符串类型的成员变量值
 * 且为所有引用数据类型的成员变量申请存储空间，且复制引用数据类型成员变量所引用的对象
 * 实现方式：
 * 1.重写clone方法
 * 2。通过对象序列化实现
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("原型模式完成对象的创建");
        Sheep sheep = new Sheep("tom",1,"白色");
        Sheep sheep2 = (Sheep)sheep.clone();
        Sheep sheep3 = (Sheep)sheep.clone();
        Sheep sheep4 = (Sheep)sheep.clone();
        Sheep sheep5 = (Sheep)sheep.clone();
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);
    }
}
