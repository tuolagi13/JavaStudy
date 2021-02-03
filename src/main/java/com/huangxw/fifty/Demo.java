package com.huangxw.fifty;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Demo {
    public static void main(String[] args) {
        //老公组
        List<Couple> husbands = new ArrayList<>();
        husbands.add(new Couple(1,"梁山伯"));
        husbands.add(new Couple(2,"牛郎"));
        husbands.add(new Couple(3,"干将"));
        husbands.add(new Couple(4,"工藤新一"));
        husbands.add(new Couple(5,"罗密欧"));
    
        //老婆组
        List<Couple> wives = new ArrayList<>();
        wives.add(new Couple(1,"祝英台"));
        wives.add(new Couple(2,"织女"));
        wives.add(new Couple(3,"莫邪"));
        wives.add(new Couple(4,"毛利兰"));
        wives.add(new Couple(5,"朱丽叶"));
        
        //第一版算法
        //code1(husbands,wives);
        //第二版算法 减少循环次数
        //code2(husbands,wives);
        //第三版算法 符合条件的wives删掉
        //code3(husbands,wives);
        //第四种算法 重点
        code4(husbands,wives);
    }
    
    public static void code1(List<Couple> husbands,List<Couple> wives) {
        //用于计算循环数
        int count = 0;
        
        for(Couple husband : husbands)
        {
            for(Couple wife : wives)
            {
                count++;
                if(husband.getFamilyId().equals(wife.getFamilyId()))
                    System.out.println(husband.getUserName() + " loves " + wife.getUserName());
            }
        }
        System.out.println("循环了：" + count);
    }
    
    public static void code2(List<Couple> husbands,List<Couple> wives) {
        //用于计算循环数
        int count = 0;
        
        for(Couple husband : husbands)
        {
            for(Couple wife : wives)
            {
                count++;
                if(husband.getFamilyId().equals(wife.getFamilyId()))
                {
                    System.out.println(husband.getUserName() + " loves " + wife.getUserName());
                    break;
                }
            }
        }
        System.out.println("循环了：" + count);
    }
    
    public static void code3(List<Couple> husbands,List<Couple> wives) {
        //用于计算循环数
        int count = 0;
        
        for(Couple husband : husbands)
        {
            for(Couple wife : wives)
            {
                count++;
                if(husband.getFamilyId().equals(wife.getFamilyId()))
                {
                    System.out.println(husband.getUserName() + " loves " + wife.getUserName());
                    wives.remove(wife);
                    break;
                }
            }
        }
        System.out.println("循环了：" + count);
    }
    
    public static void code4(List<Couple> husbands,List<Couple> wives) {
        //用于计算循环数
        int count = 0;
        Map<Integer,Couple> wifeMap = new HashMap<>();
        for(Couple wife : wives)
        {
            count++;
            wifeMap.put(wife.getFamilyId(),wife);
        }
        
        for(Couple husband : husbands)
        {
            count++;
            if(wifeMap.containsKey(husband.getFamilyId()))
            {
                System.out.println(husband.getUserName() + " loves " + wifeMap.get(husband.getFamilyId()).getUserName());
            }
        }
        
        System.out.println("循环了：" + count);
    }
}

@Data
@AllArgsConstructor
class Couple {
    private Integer familyId;
    private String userName;
}



