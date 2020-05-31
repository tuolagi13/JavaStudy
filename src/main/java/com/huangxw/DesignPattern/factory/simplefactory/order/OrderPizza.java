package com.huangxw.DesignPattern.factory.simplefactory.order;

import com.huangxw.DesignPattern.factory.simplefactory.pizza.CheesePizza;
import com.huangxw.DesignPattern.factory.simplefactory.pizza.GreekPizza;
import com.huangxw.DesignPattern.factory.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    //构造器
    public OrderPizza(){
        Pizza pizza = null;
        String orderType;    //订购pizza类型
        do {
            orderType = getType();
            if(orderType.equals("greek")){
                pizza = new GreekPizza();
                pizza.setName(orderType);
            } else if(orderType.equals("cheese")){
                pizza = new CheesePizza();
                pizza.setName(orderType);
            }else {
                break;
            }
            //输出pizza制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }

    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;
    //构造器
    public OrderPizza(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }

    public void setSimpleFactory(SimpleFactory simpleFactory){
        String orderType = "";               //用户输入的
        this.simpleFactory = simpleFactory;  //设置简单工厂对
        do{
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
            if(pizza !=null){//订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购pizza失败！");
                break;
            }
        }while(true);

    }








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
