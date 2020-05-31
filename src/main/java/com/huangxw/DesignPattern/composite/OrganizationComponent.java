package com.huangxw.DesignPattern.composite;

/**
 *组合模式要素：
 * component、leaf(叶子节点)、Composite(子部件)
 */
public abstract class OrganizationComponent {

    private String name;
    private String des;

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    protected void add(OrganizationComponent organizationComponent){
        //默认实现，如不写默认实现，所有的叶子节点都需要重写，不划算
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent){
        //默认实现，如不写默认实现，所有的叶子节点都需要重写，不划算
        throw new UnsupportedOperationException();
    }

    //print方法，做成抽象的
    protected abstract void print();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
