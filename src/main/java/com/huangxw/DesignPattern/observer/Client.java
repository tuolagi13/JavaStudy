package com.huangxw.DesignPattern.observer;

/**
 * 观察者模式
 * 需求：天气预报项目
 * 1.气象站将每天测量到的温度、湿度、气压以公告方式发布出去
 * 2.需要设计开放型API，便于第三方也能接入气象站获取数据
 * 3.测量数据更新时，要能实时的通知给第三方
 * 下面为传统设计方案
 * 问题：
 * 1.其他第三方接入气象站获取数据的问题：在WeatherData中，每增加一个第三方，都需要创建一个
 *   对应的第三方的公告板对象，并加入到dataChange
 * 2.无法在运行时动态的添加第三方
 * 3.违反OCP原则
 */
public class Client {

    public static void main(String[] args) {
        //创建接入方
        CurrentConditions currentConditions = new CurrentConditions();
        //创建WeatherData对象，并将接入方currentConditions传递到WeatherData中
        WeatherData weatherData = new WeatherData(currentConditions);

        //更新天气情况
        weatherData.setData(30,150,40);

        //天气情况变化
        System.out.println("======天气变化======");
        weatherData.setData(40,60,20);
    }
}
