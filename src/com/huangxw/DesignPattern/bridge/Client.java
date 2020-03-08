package com.huangxw.DesignPattern.bridge;

/**
 * 桥接模式
 *场景：
 * 手机操作问题，手机样式有直板、折叠等样式，品牌有小米、华为等种类
 * 如果传统方式，FoldPhone、UpRightPhone继承Phone，HuaWei、XiaoMi继承FoldPhone、BarPhone
 * 这样新增手机样式时，所有品牌都要新增此样式的继承类，造成类爆炸
 * 此时用桥接模式合适
 *桥接模式提代多层继承方案，可以减少类的个数。
 * 但桥接模式的引入增加了系统的理解和设计难度。由于聚合关系建立在抽象层，
 * 要求开发者正确识别出系统中两个独立的维度
 * 常见场景：
 * JDBC驱动程序
 * 银行转账系统
 * 银行转账类型：网上转账、柜台转账....  （抽象层）
 * 转账用户类型：普通用户、银卡用户....  （实现层）
 *
 */
public class Client {
    public static void main(String[] args) {
         //获取折叠式手机，样式+品牌
        Phone phone1 = new FoldedPhone(new XiaoMi());
        phone1.open();
        phone1.close();
        phone1.call();
        System.out.println("===========================");
        Phone phone2 = new UpRightPhone(new Vivo());
        phone2.open();
        phone2.close();
        phone2.call();
    }
}
