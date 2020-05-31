package com.huangxw.DesignPattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 * 需求：遍历colleage下所有学院的专业，不同学院可能用不同数据结构存储专业信息(数组、List)
 *此时可用迭代器模式
 */
public class Client {

    public static void main(String[] args) {

        //创建学院
        List<College> collegeList = new ArrayList<College>();
        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        OutPutImpl outPut = new OutPutImpl(collegeList);
        outPut.printCollege();

    }
}
