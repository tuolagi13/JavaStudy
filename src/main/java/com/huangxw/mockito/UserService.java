package com.huangxw.mockito;


import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private ImageService imageService;
    private RiskService riskService;

    public Map<String,String> save(Map<String,Object> user){
        System.out.println("userService  save!!!!");
        Map<String,String> resultMap = new HashMap<>();
        Map<String, List<String>> riskMap = riskService.risk(user);

        if(!riskMap.isEmpty())
        {
            for ( Map.Entry<String,List<String>> entry: riskMap.entrySet())
                resultMap.put(entry.getKey(), StringUtils.join(entry.getValue(),""));
            return resultMap;
        }
        boolean flag = imageService.upload((InputStream)user.get("headTime"));
        if(flag)
        {
            resultMap.put("headTime","上传头像失败，请稍后重试！！！");
            return resultMap;
        }
        //插入数据库等其他逻辑
        return resultMap;
    }
}
