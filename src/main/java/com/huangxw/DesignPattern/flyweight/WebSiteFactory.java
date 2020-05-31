package com.huangxw.DesignPattern.flyweight;

import java.util.HashMap;
import java.util.Map;
//网站工厂类根据需要返回一个网站
public class WebSiteFactory {

    //集合，充当池的作用
    private Map<String,ConcreteWebSite> pool = new HashMap<String,ConcreteWebSite> ();

    //根据网站类型，返回一个网站，如果没有就创建
    public WebSite getWebSiteCategory(String type){
        if(!pool.containsKey(type)){
            pool.put(type,new ConcreteWebSite(type));
        }
        return (WebSite) pool.get(type);
    }

    //获取网站分类的总数
    public int getWebSiteCount(){
        return pool.size();
    }

}
