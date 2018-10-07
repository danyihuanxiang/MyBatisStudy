package com.study.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by Administrator on 2018/6/7 0007.
 */
public class SqlSessionUtil {
    private  static  String filename= "SqlMapConfig.xml";
    private static  SqlSessionFactory factory=null;

    static {
        try {
            InputStream inputstream= Resources.getResourceAsStream(filename);
            factory=new SqlSessionFactoryBuilder().build(inputstream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static  SqlSession getSqlSession(boolean flg){
        if(null!=factory){
            return factory.openSession(flg);
        }
        return  null;
    }
    public  static void closeSqlSession(SqlSession sqlSession){
        if(null!=sqlSession){
            sqlSession.close();
        }
    }
}
