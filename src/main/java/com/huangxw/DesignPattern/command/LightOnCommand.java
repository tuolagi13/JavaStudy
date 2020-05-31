package com.huangxw.DesignPattern.command;

public class LightOnCommand implements Command {

    //聚合LightReceiver
    private LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        //调用接收者方法
        light.on();
    }

    @Override
    public void undo() {
        //调用接收者方法
        light.off();
    }
}
