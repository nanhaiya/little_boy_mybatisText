package com.leanMybatis.dao;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class UserDaoImpl {
    /**
     * 插入name
     * @throws IOException
     */
    @Test
    public void insertUser() throws IOException {
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

    public static void main(String[] args) {


    }
}
