package com.huangxw.mockito;

import com.huangxw.DesignPattern.prototype.improve.Sheep;
import com.huangxw.redis.RedisLock;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//图片服务
public class ImageService {

    public boolean upload(InputStream inputStream){
        System.out.println("imageService upload!!!");
        return true;
    }

    public boolean upload2(InputStream inputStream){
        System.out.println("imageService upload2!!!");
        return true;
    }
    public static String formatFlag(int flag){
        String ret = "";
        switch (flag) {
            case 0:
                ret = "正常";
                break;
            case 1:
                ret = "在线延迟";
                break;
            case 2:
                ret = "离线延迟";
                break;
            case 3:
                ret = "都延迟";
            default:
                break;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(formatFlag(1));

    }
}
