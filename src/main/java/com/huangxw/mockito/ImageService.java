package com.huangxw.mockito;

import java.io.InputStream;

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
}
