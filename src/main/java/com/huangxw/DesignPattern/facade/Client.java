package com.huangxw.DesignPattern.facade;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * 外观模式
 * 影院管理项目需求
 * 组建一个家庭影院：DVD播放器、投影仪、自动屏幕、立体声、爆米花机，要求按顺序执行以下功能：
 *  开爆米花机
 *  放下屏幕
 *  开投影仪
 *  开音响
 *  开DVD
 *  ..
 *  传统方式解决：创建各个设备对象，然后调用对象的方法。缺点是操作的时候因为设备太多，调用过程混乱
 *  解决思路：定义一个高层接口，给子系统中的一组接口提供一个一致的界面，用来访问子系统中的一群接口
 *  即为外观模式
 *  外观模式三个角色：外观类、子系统、Client
 */
public class Client {

    public static void main(String[] args) {

        //直接调用各个设备很麻烦

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();

    }
}
