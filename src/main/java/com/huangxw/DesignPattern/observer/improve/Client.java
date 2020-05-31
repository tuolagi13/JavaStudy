package com.huangxw.DesignPattern.observer.improve;


/**
 * 优化方案：观察者模式
 *主要角色：
 * 1.Subject
 * 2.Observer
 *
 */
public class Client {

    public static void main(String[] args) {

        //创建一个weatherdata
        WeatherData weatherData = new WeatherData();

        //创建一个观察者
        CurrentConditions conditions = new CurrentConditions();
        weatherData.registerObserver(conditions);

        //创建另一个观察者
        BaiduSite baiduSite = new BaiduSite();
        weatherData.registerObserver(baiduSite);

        //更新天气情况
        System.out.println("通知各个注册的观察者，看信息");
        weatherData.setData(30,150,40);

    }
}
