package com.leanMybatis.dao;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hamcrest.Condition;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class UserDaoImpl {
    /**
     * 插入name
     * @test标签：类名不能有test，类方法不能为static
     * @throws IOException
     */
    @Test  //Junit测试
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

    @Test
    public void insertBookByParam() throws IOException {
        String name="little_boy_other";
        long token=1;
        SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
        InputStream ins=Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory ssfc =ssfb.build(ins);
        SqlSession session=ssfc.openSession();
        //执行插入操作
        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put("name",name);
        paramMap.put("id",token);

        int flag=session.insert("com.leanMybatis.dao.UserDaoImpl.insertBookByParam",paramMap);
        System.out.println("flag="+flag);
        session.commit();

    }
}
