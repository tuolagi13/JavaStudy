package com.huangxw.mockito;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//测试类
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    //由Mockito框架根据接口的实现帮我们创建一个实例对象（注意是实例对象，所以调用该类的方法都会被执行）
    // 同时会根据@Mock的类与@InjectMocks标识的类中的属性类型进行匹配，如果完全一致，自动注入属性值，类似于Spring的IOC功能
    @InjectMocks
    private UserService userService;

    //由Mockito框架根据接口的实现帮我们mock一个虚假对象，调用该对象的方法时，方法不会真正被执行
    @Mock
    private ImageService imageService;

    //由Mockito框架根据接口的实现帮我们mock一个真实实例对象（注意是实例对象，所以调用该类的方法都会被执行）
    // 调用该对象的方法时，方法会真正被执行
    @Spy
    private RiskService riskService;


    @Before
    public void init(){
        //这句话执行以后，imageService、riskService等userService依赖的bean会自动注入到userService中。
        //与@RunWith(MockitoJUnitRunner.class) 等价，选一个即可
        //MockitoAnnotations.initMocks(this);
        printLog("打印成员变量参数：", "imageService：", getFieldValue(userService,"imageService"),
                "，userService：", userService, "，riskService：", getFieldValue(userService,"riskService"));
    }

    @After
    public void after(){
        printLog("执行成功！");
    }

    @Test
    public void testWhen(){
        Mockito.when(imageService.upload(Mockito.any())).thenReturn(true);
        Mockito.when(riskService.risk(Mockito.anyMap())).thenReturn(new HashMap<>());
        //Mockito.when(userService.save(Mockito.anyMap())).thenReturn(new HashMap<>());
        userService.save(new HashMap<>());
    }

    @Test
    public void testVerify(){
        testWhen();
        Mockito.verify(imageService,Mockito.times(1)).upload(Mockito.any());
    }

    @Test
    public void testInOrder(){
        //验证调用顺序
        testWhen();
        final InOrder inOrder = Mockito.inOrder(riskService,imageService);
        inOrder.verify(riskService).risk(Mockito.anyMap());
        inOrder.verify(imageService).upload(Mockito.any());

    }

    @Test
    public void testAtLeastOnce(){
        testWhen();
        testWhen();
        Mockito.verify(riskService,Mockito.atLeastOnce()).risk(Mockito.anyMap());
        Mockito.verify(imageService,Mockito.atLeastOnce()).upload(Mockito.any());
    }

    @Test
    public void testNever(){
        Mockito.verify(riskService,Mockito.never()).risk(Mockito.anyMap());
        //设置引用
        //testWhen();
        //会执行错误
        //Mockito.verify(riskService,Mockito.never()).risk(Mockito.anyMap());
    }

    @Test
    public void testArgumentCaptor(){
        //正常请求
        Map<String,Object> param = new HashMap<>();
        param.put("headImage",Mockito.any(InputStream.class));
        userService.save(param);
        //对上面执行的参数进行抓取
        ArgumentCaptor<Map> captor = ArgumentCaptor.forClass(Map.class);
        Mockito.verify(riskService).risk(captor.capture());
        Assert.assertEquals(captor.getValue(),param);
    }

    @Test
    public void testVerifyNoMoreInteractions(){
        //verifyNoMoreInteractions()方法可以传入多个mock对象作为参数，用来验证传入的这些mock对象是否存在没有验证过的调用方法。
        // 为了增加测试的可维护性，官方不推荐我们过于频繁的在每个测试方法中都使用它，因为它只是测试的一个工具，只在你认为有必要的时候才用。
        UserService userService = Mockito.mock(UserService.class);
        //正确执行
        Mockito.verifyNoMoreInteractions(userService);
        //重置引用
        Mockito.reset(userService);
        //正确执行
        Mockito.verifyNoMoreInteractions(userService);
        // 设置引用
        userService.save(Mockito.anyMap());
        //执行这里会报错,因为没有verify save方法
        //Mockito.verifyNoMoreInteractions(userService);
    }

    @Test
    public void testDoException(){
        //调用save时抛出空指针异常
        Mockito.doThrow(new NullPointerException()).when(Mockito.mock(UserService.class)).save(null);
    }

    @Test
    public void testa(){
        Map<String ,Object> param = new HashMap<>();
        param.put("headTime",Mockito.any(InputStream.class));
        userService.save(param);
    }




    /**
     * 打印日志
     *
     * @param objs
     */
    private void printLog(Object... objs) {
        if (objs == null && objs.length == 0) {
            System.out.println("参数为空，没有什么东西可以打印的");
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(objs).forEach(obj -> sb.append(obj));
        System.out.println(sb.toString());
    }

    public static <T> T getFieldValue(Object obj, String fieldName) {
        if (obj == null) {
            return null;
        }
        if (StringUtils.isBlank(fieldName)) {
            return null;
        }
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        try {
            for (Field field : fields) {
                if (field.getName().equals(fieldName)) {
                    field.setAccessible(true);
                    return (T) field.get(obj);
                }
            }
            // 如果子类没有属性，看看父类是否有该属性
            if (objClass.getSuperclass() == null) {
                return null;
            }
            Object parentObj = objClass.getSuperclass().newInstance();
            BeanUtils.copyProperties(obj, parentObj);
            return getFieldValue(parentObj, fieldName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
