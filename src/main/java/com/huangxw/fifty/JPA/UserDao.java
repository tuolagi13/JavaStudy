package com.huangxw.fifty.JPA;

import java.util.Date;

public class UserDao extends BaseDao<SysVersion> {
    
    @Override
    public void add(SysVersion bean) {
        super.add(bean);
    }
    
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        SysVersion sysVersion = new SysVersion(1,"123",new Date(),"test");
        userDao.add(sysVersion);
    }
}
