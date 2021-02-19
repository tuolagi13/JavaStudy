package com.huangxw.fifty.Enum;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *自定义枚举转换器 基于MyBatis
 */
@MappedTypes({WeekDayEnum.class})
public class MyEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {
    
    private final Class<E> type;
    private final E[] enums;
    
    public MyEnumTypeHandler(Class<E> type) {
        if(type == null )
            throw new IllegalArgumentException("Type argument cannot be null");
        
        this.type = type;
        this.enums = type.getEnumConstants();
        if(this.enums == null)
            throw new IllegalArgumentException(type.getSimpleName() + "does not represent an enum type.");
    }
    
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if(jdbcType == null)
        {
            //获取WeekDayEnum所有字段并循环，找到带有@EnumValue注解的字段
            Field[] declaredFields = type.getDeclaredFields();
            for(Field field : declaredFields)
            {
                //是否有@EnumValue注解
                EnumValue enumValue = field.getAnnotation(EnumValue.class);
                if(enumValue != null)
                {
                    Object fieldValue = null;
                    try
                    {
                        //反射获取标记了@EnumValue注解的字段的value
                        field.setAccessible(true);
                        fieldValue = field.get(parameter);
                    } 
                    catch (IllegalAccessException e) 
                    {
                        e.printStackTrace();
                    }
                    //设置值
                    ps.setObject(i,fieldValue);
                }
                else
                {
                    //不考虑jdbcType != null 的情况
                    ps.setObject(i,parameter.name(),jdbcType.TYPE_CODE);
                }
            }
            
        }
    }
    
    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        //定义一个变量，接收从数据库查出的rest_day
        Object valueFromDB = null;
        
        //确定但是存入时制定了哪个字段
        Field enumValueField = null;
        Field[] declaredFields = type.getDeclaredFields();
        for(Field field : declaredFields)
        {
            //是否有@EnumValue注解
            EnumValue enumValue = field.getAnnotation(EnumValue.class);
            if(enumValue != null)
            {
                //找到带有@EnumValue的字段
                enumValueField = field;
                //数据库返回了ResultSet，也即是查询结果集，我们可以从中获取restDay的值
                valueFromDB = rs.getObject(columnName,enumValueField.getType());
                break;
            }
        }
        
        //如果没有标注@EnumValue，还是按默认解析返回
        if(enumValueField == null)
            return getResultByOrdinal(rs,columnName);
        
        //遍历weekDayEnum的所有实例，反射获取每个实例中注解了@EnumValue的字段值并比较
        enumValueField.setAccessible(true);
        for(E weekday : enums)
        {
            Object value = null;
            try
            {
                value = enumValueField.get(weekday);
                if(valueFromDB.equals(value))
                    return weekday;
                    
            } 
            catch (IllegalAccessException e) 
            {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    private E getResultByOrdinal(ResultSet rs,String columnName) throws SQLException {
        int ordinal = rs.getInt(columnName);
        if(ordinal == 0 && rs.wasNull())
            return null;
        
        return toOrdinalEnum(ordinal);
    }
    
    private E toOrdinalEnum(int ordinal) {
        try
        {
            return enums[ordinal];    
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Cannot convert " + ordinal + " to " + type.getSimpleName() + " by ordinal value.",ex);
        }
    }
    
    
    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
    
    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
