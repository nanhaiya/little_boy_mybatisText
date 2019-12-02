package com.leanMybatis.dao;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hamcrest.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class UserDaoImpl {
    private SqlSession session=null;

    @Before
    public void init() throws IOException {
        //SqlSession--->SqlSessionFactory--->SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
        //将mybatis.xml文件变成字节流
        InputStream ins= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory ssf=ssfb.build(ins);
        session =ssf.openSession();
    }

    @After
    public void end(){
        //提交事务
        session.commit();
    }

    /**
     * 插入name
     * @test标签：类名不能有test，类方法不能为static
     * @throws IOException
     */
    @Test  //Junit测试
    public void insertUser() throws IOException {


        //执行
        int flag=session.insert("com.leanMybatis.dao.UserDaoImpl.insertUser");
        System.out.println("flag="+flag);
    }

    @Test
    public void insertBookByParam() throws IOException {
        String name="little_boy_other-test";
        long token=1;

        //执行插入操作
        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put("name",name);
        paramMap.put("token",token);

        int flag=session.insert("com.leanMybatis.dao.UserDaoImpl.insertBookByParam",paramMap);
        System.out.println("flag="+flag);


    }

    @Test
    public void updateDate() throws IOException {
        String name="little";
        int id=8;

        //执行修改操作
        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put("name",name);
        paramMap.put("id",id);

        int flag=session.update("com.leanMybatis.dao.UserDaoImpl.updateDate",paramMap);
        System.out.println("flag="+flag);

    }

    @Test
    public void deleteData() throws IOException {
        int id=6;

        //执行删除操作
        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put("id",id);

        int flag=session.delete("com.leanMybatis.dao.UserDaoImpl.deleteData",paramMap);
        System.out.println("flag="+flag);

    }
}
