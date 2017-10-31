package test;

import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 15:18 2017/10/31
 * @Modified By:
 */
public class MyBatis_Test {
    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器来加载mybatis的配置文件
        InputStream in = MyBatis_Test.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(in);

        //第二种构建sqlSession的工厂的方法
        //使用MyBatis提供的Resourcec类加载mybatis的配置文件
        //Reader reader = Resource.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //创建能执行映射文件的sql的sqlSession
        SqlSession session = sessionFacotry.openSession();
        /*映射sql的标识字符串
          mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值
          getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapping.userMapper.getUser";
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement,3);
        System.out.println(user);

    }
}
