package com.huangxw.fifty.JPA;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class BaseDao<T> {
    private static BasicDataSource dataSource;
    
    static 
    {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/alc_shengshi?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT");
        dataSource.setUsername("jbzerp");
        dataSource.setPassword("sanyjbz888");
    }
    
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    //DAO的操作对象
    private Class<T> beanClass;
    
    /**
     * 构造器
     * 初始化时完成对实际参数的获取，比如BaseDao<User>插入User，那么beanClass就是User.class
     */
    public BaseDao() {
        beanClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public void add(T bean) {
        //得到SysVersion对象的所有字段
        Field[] fields = beanClass.getDeclaredFields();
        String tableName = beanClass.getAnnotation(Table.class).value();
        //拼接sql语句，表名直接用POJO类名
        StringBuilder sql = new StringBuilder()
                                .append("insert into ")
                                .append(tableName)
                                .append(" values(");
    
        for (int i = 0; i < fields.length; i++) 
        {
            sql.append("?");
            if( i < fields.length - 1)
                sql.append(",");
        }
        sql.append(")");
        
        //获得bean字段的值(要插入的记录)
        ArrayList<Object> paramList = new ArrayList<>();
        try 
        {
            for (Field field : fields) 
            {
                field.setAccessible(true);
                Object o = field.get(bean);
                paramList.add(o);
            }
        } 
        catch (IllegalAccessException e) 
        {
            e.printStackTrace();
        }
        int size = paramList.size();
        Object[] params = paramList.toArray(new Object[size]);
        //传入sql语句模板和模板所需的参数 插入User
        System.out.println("拼接sql: " + sql.toString());
        int num = jdbcTemplate.update(sql.toString(),params);
        System.out.println(num);
    
    }
}
