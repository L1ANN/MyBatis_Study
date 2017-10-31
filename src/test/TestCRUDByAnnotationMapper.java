package test;

import domain.User;
import mapping.UserMapperI;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import util.MyBatisUtil;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 21:42 2017/10/31
 * @Modified By:
 */
public class TestCRUDByAnnotationMapper {

    @Test
    public void testAdd(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象
        // UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来的
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        User user =new User();
        user.setName("用户lpf");
        user.setAge(23);
        //执行增加操作
        int add = mapper.add(user);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(add);
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession  = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象
        //UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        User user= new User();
        user.setId(4);
        user.setName("L1ANN_lpf");
        user.setAge(23);
        //执行修改操作
        int retResult = mapper.update(user);
        //使用SqlSession 执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }
    @Test
    public void testDelete(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象
        //UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //执行删除操作
        int retResult = mapper.deleteById(4);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }
    @Test
    public void testGetUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //执行查询操作，将查询结果自动封装成User返回
        User user = mapper.getById(5);
        sqlSession.close();
        System.out.println(user);
    }
    @Test
    public void testGetAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<User> users = mapper.getAll();
        sqlSession.close();
        System.out.println(users);
    }
}
