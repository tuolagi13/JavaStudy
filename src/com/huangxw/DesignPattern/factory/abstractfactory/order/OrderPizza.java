package com.huangxw.DesignPattern.factory.abstractfactory.order;

import com.huangxw.DesignPattern.factory.abstractfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    AbstractFactory factory;

    public OrderPizza(AbstractFactory factory){
        setFactory(factory);
    }

    private void setFactory(AbstractFactory factory){
        this.factory = factory;
        String orderType = "";
        Pizza pizza = null;
        do {
            orderType = getType();
            //factory可能是北京工厂子类，也可能是伦敦工厂子类
            pizza = factory.createFactory(orderType);
            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("~~制作pizza失败~~");
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
