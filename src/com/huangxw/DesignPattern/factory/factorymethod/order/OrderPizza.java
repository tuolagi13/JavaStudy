package com.huangxw.DesignPattern.factory.factorymethod.order;



import com.huangxw.DesignPattern.factory.factorymethod.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public abstract class OrderPizza {

    //构造器
    public OrderPizza(){
        Pizza pizza = null;
        String orderType;    //订购pizza类型
        do {
            orderType = getType();
            pizza = createPizza(orderType);
            //输出pizza制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }

    //定义一个抽象方法，createPizza，让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);


    //写一个方法，获取客户希望订购的pizza种类
    private String getType(){
        try{
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }


}
