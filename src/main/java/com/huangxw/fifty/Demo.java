package com.huangxw.fifty;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


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
        code1(husbands,wives);
        
    }
    
    public static void code1(List<Couple> husbands,List<Couple> wives) {
        //用于计算循环数
        int count = 0;
        
        for(Couple husband : husbands)
        {
            
        }
        
    }
    
}

@Data
@AllArgsConstructor
class Couple {
    private Integer familyId;
    private String userName;
}



