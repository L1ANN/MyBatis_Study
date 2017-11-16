package test;

import domain.User;
import domain.UserQueryVo;
import mapping.userMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import util.MyBatisUtil;

import java.util.ArrayList;
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

    /**
     * 测试动态SQL语句
     */
    @Test
    public void testfindUserList(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        String statement = "mapping.userMapper.findUserList";
        User user = new User();
        user.setName("l");
        user.setAge(23);
        List<User> users = sqlSession.selectList(statement,user);
        sqlSession.close();
        System.out.println(users);
    }

    /**
     * 测试动态SQL语句
     */
    @Test
    public void testfindUserCount(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        String statement = "mapping.userMapper.findUserCount";
        User user = new User();
        user.setName("l");
        user.setAge(23);
        int count = sqlSession.selectOne(statement,user);
        sqlSession.close();
        System.out.println("总记录数："+count);
    }

    /**
     * 测试动态SQL语句
     */
    @Test
    public void testfindUserList1(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        String statement = "mapping.userMapper.findUserList1";
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setName("l");
        user.setAge(23);
        userQueryVo.setUser(user);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(5);
        userQueryVo.setIds(ids);
        List<User> users = sqlSession.selectList(statement,userQueryVo);
        sqlSession.close();
        System.out.println(users);
    }

    /**
     * 测试Mapper动态代理实现DAO层
     * @throws Exception
     */
    @Test
    public void testMapper_GetUser() throws Exception{
        //通过SqlSessionFacotry获取SqlSession对象
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //通过sqlSession创建userMapper接口类的代理对象（实体类）赋给usermapper
        userMapper usermapper = sqlSession.getMapper(userMapper.class);
        //调用usermapper的方法体获取User
        User user = usermapper.getUser(2);
        //关闭SqlSession
        sqlSession.close();
        System.out.println(user);
    }

    /**
     * 测试Mapper动态代理实现DAO层
     * @throws Exception
     */
    @Test
    public void testMapper_GetUserList() throws Exception{
        SqlSession sqlSession  = MyBatisUtil.getSqlSession(true);
        userMapper usermapper = sqlSession.getMapper(userMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setName("l");
        user.setAge(23);
        userQueryVo.setUser(user);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(5);
        userQueryVo.setIds(ids);

        List<User> users = usermapper.findUserList1(userQueryVo);
        sqlSession.close();
        System.out.println(users);

    }
}
