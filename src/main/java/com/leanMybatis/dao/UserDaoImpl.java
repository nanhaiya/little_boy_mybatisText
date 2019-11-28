package com.leanMybatis.dao;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class UserDaoImpl {
    public static void main(String[] args) throws IOException {
        //SqlSession--->SqlSessionFactory--->SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
        //将mybatis.xml文件变成字节流
        InputStream ins= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory ssf=ssfb.build(ins);
        SqlSession session =ssf.openSession();

        //执行
        int flag=session.insert("com.leanMybatis.dao.UserDaoImpl.insertUser");
        System.out.println("flag="+flag);
        //提交事务
        session.commit();
    }
}
