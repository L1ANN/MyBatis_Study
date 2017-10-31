package test;

import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import util.MyBatisUtil;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:09 2017/10/31
 * @Modified By:
 */
public class TestCRUDByXmlMapper {

    @Test
    public void testAdd() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        //映射sql的标识字符串
        String statement = "mapping.userMapper.addUser";
        User user = new User();
        user.setName("林雪");
        user.setAge(24);

        //执行插入操作
        int retResult = sqlSession.insert(statement, user);
        //如果getSqlSession设置为false，需要手动提交事务
        //sqlSession.commit();

        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        //映射sql的标识字符串
        String statement = "mapping.userMapper.updateUser";
        User user = new User();
        user.setId(3);
        user.setAge(25);
        user.setName("林强");
        //执行修改操作
        int resResult = sqlSession.update(statement,user);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(resResult);
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession  = MyBatisUtil.getSqlSession(true);

        //映射sql的标识字符串
        String statement = "mapping.userMapper.deleteUser";
        //执行删除操作
        int retResult = sqlSession.delete(statement,3);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    @Test
    public void testGetAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        //映射sql的标识字符串
        String statement = "mapping.userMapper.getAllUsers";
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<User> lstUsers = sqlSession.selectList(statement);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(lstUsers);
    }
}
