package com.huangxw.DesignPattern.prototype.deepclone;

import java.io.*;

public class DeepProtoType implements Serializable,Cloneable {

    public String name;
    public DeepCloneableTarget deepCloneableTarget;  //引用类型


    //深拷贝 --方式1 使用clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //完成基本数据类型与字符串的克隆
        deep = super.clone();
        //对引用类型属性单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    //深拷贝 -- 方式2 对象序列化实现(推荐使用)
    public Object deepClne(){

        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);              //把当前对象以对象流方式输出

            //反序列化
             bis = new ByteArrayInputStream(bos.toByteArray());
             ois = new ObjectInputStream(bis);
             DeepProtoType copyObj = (DeepProtoType)ois.readObject();
             return copyObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}