package com.huangxw.DesignPattern.prototype;

/**
 * 克隆问题
 * 一只羊tom，有姓名、年龄、颜色属性，请编写程序创建和tom属性完全一致的10只羊
 *传统方式优缺点
 * 优点：好理解，操作简单
 * 缺点：
 * 1.创建新对象时，总需要重新获取原始对象的属性，如果对象属性比较复杂，很麻烦
 * 2.总是需要重新初始化对象，而不是动态获取对象运行时的状态，不够灵活(假如原始对象信息变化了，我们希望新建对象动态跟着变化)
 *
 * 思路：
 * Java中Object类提供了一个clone()方法，只要对象实现接口cloneable，即可使用此方法复制对象
 */
public class Client {
    public static void main(String[] args) {
        //传统的方法
        Sheep sheep = new Sheep("tom",1,"白色");
        Sheep sheep2 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep4 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep5 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);
    }
}
