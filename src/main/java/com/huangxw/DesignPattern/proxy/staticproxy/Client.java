package com.huangxw.DesignPattern.proxy.staticproxy;

/**
 * 静态代理
 * 接口、代理对象、目标i对象
 * 优点：
 * 代理对象可以对目标对象进行扩展
 * 缺点：
 * 代理对象需要与目标对象实现同样的接口，所以会有很多的代理类，一旦接口增加方法，目标对象
 * 与代理对象都要维护
 */
public class Client {
    public static void main(String[] args) {

        //目标对象
        TeacherDao teacherDao = new TeacherDao();
        //代理对象
        TeacherDaoProxy proxy = new TeacherDaoProxy(teacherDao);
        //通过代理对象，调用目标对象的方法
        proxy.teach();
    }
}
