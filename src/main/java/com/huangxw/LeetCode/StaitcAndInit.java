package com.huangxw.LeetCode;


class Base {
    static int a = 1;

    public Base() {
        System.out.println("Base构造函数启动");
    }

    static {
        System.out.println("Base Static启动");
    }

    static void method() {
        System.out.println("Base method启动");
    }
}

class Sub extends Base {
    public Sub() {
        System.out.println("Sub构造函数启动");
    }

    static int b = 2;
    static {
        System.out.println("Sub Static启动");
    }

}

public class StaitcAndInit {

    public static void main(String[] args) {
        Sub sub = new Sub();  //Base static -> Sub static -> Base 构造 -> Sub 构造
        Sub suba = new Sub(); //再次新建对象，static不再执行   Base 构造 -> Sub 构造
        //Sub.method();//调用static程序段,先于构造函数执行，且永远只执行一次
        //System.out.println("a=" + Sub.b);
    }
}
