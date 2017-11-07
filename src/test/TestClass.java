package test;

import domain.Classes;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import util.MyBatisUtil;

/**
 * @Author:L1ANN
 * @Description: 测试 一对一关联表查询,一对多关联表查询
 * @Date:Created in 21:50 2017/11/1
 * @Modified By:
 */
public class TestClass {
    @Test
    public void testGetClass() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //映射SQL的标识字符串
        String statement = "mapping.classMapper.getClass";
        //执行查询操作，将查询结果自动封装成classes对象返回
        Classes clazz = sqlSession.selectOne(statement, 2);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(clazz);
    }

    @Test
    public void testGetClass2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        String statement = "mapping.classMapper.getClass2";
        Classes clazz = sqlSession.selectOne(statement, 2);
        sqlSession.close();
        System.out.println(clazz);
    }

    @Test
    public void testGetClass3(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession(true);
        String statement = "mapping.classMapper.getClass3";
        Classes clazz = sqlSession.selectOne(statement,2);
        sqlSession.close();
        System.out.println(clazz);
    }

    @Test
    public void testGetClass4(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        String statement = "mapping.classMapper.getClass4";
        Classes clazz = sqlSession.selectOne(statement,2);
        sqlSession.close();
        System.out.println(clazz);
    }
}
