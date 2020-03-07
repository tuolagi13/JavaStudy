package com.huangxw.DesignPattern.prototype.deepclone;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String cloneClass;

    public DeepCloneableTarget(String name, String cloneClass) {
        this.name = name;
        this.cloneClass = cloneClass;
    }

    //因为该类的属性都是string，用默认clone方法即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
