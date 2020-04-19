package com.huangxw.DesignPattern.decorator;

/**
 * 项目需求：
 * 星巴克咖啡订单项目
 * 咖啡种类/单品咖啡：Espresso、ShortBlack、LongBlack等
 * 调料：Milk、Chocolate、Soy等
 * 要求方便的计算不同种类咖啡的费用，客户可以点单品咖啡，也可以单品咖啡+调料组合
 *
 * 装饰者模式
 * 装饰者对象包含被装饰者对象实例
 *
 * 装饰者模式优缺点：
 * 优点：动态地为对象增加新的功能或者撤销功能（继承就不能做到这一点）
 * 缺点：会产生过多的相似的对象，不容易拍错！
 */
public class CoffeeBar {
    public static void main(String[] args) {
        //装饰者模式下的订单，2份巧克力+1份牛奶的LongBlack

        //1.点一份LongBlack
        Drink order = new LongBlack();
        System.out.println("费用1 = " + order.cost());
        System.out.println("描述 = " + order.getDes());

        //2.order加入1份牛奶
        order = new Milk(order);
        System.out.println("order加入一份牛奶 费用=" + order.cost());
        System.out.println("order加入一份牛奶 描述=" + order.getDes());

        //3.加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order加入1份牛奶1份巧克力 费用=" + order.cost());
        System.out.println("order加入1份牛奶1份巧克力 描述=" + order.getDes());
    }
}
