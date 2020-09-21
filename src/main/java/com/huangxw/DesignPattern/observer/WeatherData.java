package com.huangxw.DesignPattern.observer;

/**
 * 核心类
 * 1.包含最新天气信息
 * 2.含有CurrentCondition对象
 * 3.当数据有更新时，主动调用含有CurrentCondition对象的update方法（含display方法）
 *  这样他们(接入方)就看到最新的信息
 */
public class WeatherData {

    //温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;

    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void dataChange(){
        currentConditions.update(getTemperature(),getPressure(),getHumidity());
    }

    //当数据有更新时，就调用setData
    public void setData(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange,将最新信息推送给接入方
        dataChange();
    }

}
