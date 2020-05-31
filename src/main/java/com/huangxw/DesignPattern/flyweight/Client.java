package com.huangxw.DesignPattern.flyweight;

/**
 * 享元模式
 * 展示网站项目需求
 * 希望以新闻、博客、微信公众号等不同形式展示网站
 * 传统方案：
 * 复制粘贴一份，根据客户不同要求改进；或给不同类型网站租用不同空间。
 * 这样会造成服务器资源浪费
 * 结局思路：
 *  整合到一个网站中，共享相关的代码和数据，减少服务器资源，即为享元模式
 *  string与各类池技术都是用到享元模式
 *  享元模式的角色与职责：
 *  1.FlyWeight：抽象的享元角色，是产品的抽象类，同时定义出对象的外部状态与内部状态
 *      外部状态：对象共享的信息，存储在享元对象内部，不随环境变化而变化
 *      内部状态：对象依赖的一个标记，随环境变化而变化、不可共享的状态
 *  2.ConcreteFlyWeight：具体的享元角色，实现抽象角色定义相关业务
 *  3.UnsharedConcreteFlyWeight：不可共享的j角色，一般不会出现在享元工厂
 *  4.FlyWeightFactory：享元工厂类，用于构建一个池(集合)，同时提供从池中获取对象方法
 */
public class Client {

    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite webSite1 = factory.getWebSiteCategory("新闻");
        webSite1.use(new User("张三"));

        WebSite webSite2 = factory.getWebSiteCategory("博客");
        webSite2.use(new User("李四"));

        WebSite webSite3 = factory.getWebSiteCategory("博客");
        webSite3.use(new User("王五"));

        System.out.println("网站数量：" + factory.getWebSiteCount());


    }
}
