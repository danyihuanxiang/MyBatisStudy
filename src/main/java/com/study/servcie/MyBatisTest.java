package com.study.servcie;

import com.study.domain.School;
import com.study.domain.Student;
import com.study.mapper.SchoolMapper;
import com.study.mapper.StudentMapper;
import com.study.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {
    public static SqlSession getSqlSession() throws FileNotFoundException {
        //配置文件
        InputStream configFile = new FileInputStream(
                "E:\\Intellij\\MyBatisStudy\\src\\main\\resources\\SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        //加载配置文件得到SqlSessionFactory
        return sqlSessionFactory.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (null != sqlSession) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void save() throws Exception {
        School school = new School();
        school.setSchoolname("小明");
        school.setStudentids(2);
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        SchoolMapper mapper = sqlSession.getMapper(SchoolMapper.class);
        School school1 = mapper.selectByPrimaryKey(1);
        System.out.println(school1);
/*        int i1 = mapper.updateByPrimaryKeySelective(school);
        System.out.println(i1);*/

        System.out.println(school);
        SqlSessionUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void saveDeptBatchTwo() {
        //设置ExecutorType.BATCH原理：把SQL语句发个数据库，数据库预编译好，数据库等待需要运行的参数，接收到参数后一次运行，ExecutorType.BATCH只打印一次SQL语句，多次设置参数步骤，
        SqlSession sqlsession=null;
        try {
           sqlsession = SqlSessionUtil.getSqlSession(true);
            SchoolMapper schoolMapper = sqlsession.getMapper(SchoolMapper.class);
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                School school = new School();
                school.setSchoolname("小明");
                school.setStudentids(2);
                schoolMapper.insertSelective(school);
            }
            SqlSessionUtil.closeSqlSession(sqlsession);
            long end = System.currentTimeMillis();
            System.out.println("耗时:" + (end - start));
               //BATCH批量耗时 耗时:822
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlSessionUtil.closeSqlSession(sqlsession);
        }
    }

  @Test
    public void 一对一(){
      SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
      StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
      Student student = mapper.selectFindList(1);
      System.out.println(student);
      System.out.println(student.getSchool());


      SqlSessionUtil.closeSqlSession(sqlSession);
  }
  @Test
    public  void  一对多(){
      SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
      SchoolMapper mapper = sqlSession.getMapper(SchoolMapper.class);
      School school = mapper.SchoolStudentList(1);
      System.out.println(school);
  }
}
