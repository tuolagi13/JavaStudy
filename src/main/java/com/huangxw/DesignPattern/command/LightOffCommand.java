package com.huangxw.DesignPattern.command;

public class LightOffCommand implements Command {

    private LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        //调用接收者方法
        light.off();
    }

    @Override
    public void undo() {
        //调用接收者方法
        light.on();
    }
}
