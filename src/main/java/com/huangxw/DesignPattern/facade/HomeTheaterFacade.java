package com.huangxw.DesignPattern.facade;

public class HomeTheaterFacade {
    //定义各个子系统对象
    private DVDPlayer dvdPlayer;
    private PopCorn popCorn;
    private Projector projector;
    private Screen screen;
    private Stereo stereo;
    private TheaterLight theaterLight;

    public HomeTheaterFacade() {
        this.dvdPlayer = DVDPlayer.getInstance();
        this.popCorn = PopCorn.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.stereo = Stereo.getInstance();
        this.theaterLight = TheaterLight.getInstance();
    }

    //操作分成四步
    public void ready(){
        popCorn.on();
        popCorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvdPlayer.on();
        theaterLight.dim();
    }

    public void play(){
        dvdPlayer.play();
    }

    public void pause(){
        dvdPlayer.pause();
    }

    public void end(){
        popCorn.off();
        screen.up();
        projector.off();
        stereo.off();
        dvdPlayer.off();
        theaterLight.bright();
    }

}
