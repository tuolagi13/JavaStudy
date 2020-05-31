package com.huangxw.DesignPattern.command;

/**
 *命令模式
 * 需求：一个App控制家中不同厂家的家电
 *使用命令模式，将"动作的请求者"从"动作的执行者"对象中解耦出来
 * 命令模式角色及职责：
 * Invoker：调用者角色
 * Command：命令角色，需要执行的命令都在这里，可以是抽象类或接口
 * Receiver：接收者角色，知道如何执行一个请求相关的操作
 * ConcreteCommand：将一个接收者对象与一个动作绑定，调用接收者相应的操作，实现execute()
 */
public class Client {

    public static void main(String[] args) {

        //使用命令设计模式，完成通过遥控器，对电灯的操作

        //创建电灯的对象(接收者)
        LightReceiver receiver = new LightReceiver();
        //创建电灯相关的开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(receiver);
        LightOffCommand lightOffCommand = new LightOffCommand(receiver);
        //需要一个遥控器
        RemoteController controller = new RemoteController();
        //给遥控器设置相关命令，比如no=0为电灯开关操作
        controller.setCommand(0,lightOnCommand,lightOffCommand);

        System.out.println("------按下灯的开按钮------");
        controller.onButtionWasPushed(0);
        System.out.println("------按下灯的关按钮------");
        controller.offButtionWasPushed(0);
        System.out.println("------按下撤销的按钮------");
        controller.undoButtionWasPushed();


    }
}
