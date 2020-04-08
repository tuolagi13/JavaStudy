package com.huangxw.DesignPattern.command;

public class RemoteController {

    //开 按钮的命令数组
    private Command[] onCommands;
    //关 按钮的命令数组
    private Command[] offCommands;

    //执行撤销的命令
    private Command undoCommand;


    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    //给我们的按钮设置需要的命令
    public void setCommand(int no,Command onCommand,Command offCommand){
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    //按下开的按钮
    public void onButtionWasPushed(int no){
        //找到按下的开的按钮，并调用对应方法
        onCommands[no].execute();
        //记录这次操作，用于撤销按钮，撤销此次操作
        undoCommand = onCommands[no];
    }

    //按下关的按钮
    public void offButtionWasPushed(int no){
        //找到按下的关的按钮，并调用对应方法
        offCommands[no].execute();
        //记录这次操作，用于撤销按钮，撤销此次操作
        undoCommand = offCommands[no];
    }

    //按下撤销按钮
    public void undoButtionWasPushed(){
        undoCommand.undo();
    }
}
