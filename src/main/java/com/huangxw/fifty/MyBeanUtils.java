package com.huangxw.fifty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyBeanUtils {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(MyBeanUtils.class);
    
    /**
     * 浅拷贝
     *将包含BeanA的list，转换为柏寒BeanB的list。应用场景示例：List<DO>转List<TO>
     */
    public static <T> List<T> copyList(List<?> sourceList,Class<T> targetClaass) {
        if(sourceList == null)
            return null;
        
        List<T> targetList = new ArrayList<>();
        for(Object tempSrc : sourceList)
        {
            T t = copyBean(tempSrc,targetClaass);
            targetList.add(t);
        }
        return targetList;
        
    }
    
    /**
     * 浅拷贝，本质和spring的BeanUtils一样
     */
    public static <T> T copyBean(Object srcBean,Class<T> targetClass) {
        try {
            T t = targetClass.newInstance();
            BeanUtils.copyProperties(srcBean,t);
            return t;
        } catch (Exception e) {
            LOGGER.error("copyBean failed");
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * 深拷贝 通过序列化实现
     */
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>)in.readObject();
        return dest;
    }
}
