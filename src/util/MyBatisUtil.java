package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:21 2017/10/31
 * @Modified By:
 */
public class MyBatisUtil {

    /**
     * 获取SqlSessionFactory
     * @return SqlSessionFactory对象
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        InputStream in  = MyBatisUtil.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        return factory;
    }

    /**
     * 获取SqlSession
     * @return sqlSession
     */
    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }

    /**
     * 获取SqlSession
     * @param isAutoCommit  true:表示创建的SqlSession对象在执行完SQL之后会自动提交事务
     *                      false：表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，需要调用SqlSession.commit（）提交事务
     * @return
     */
    public static SqlSession getSqlSession(boolean isAutoCommit){
        return getSqlSessionFactory().openSession(isAutoCommit);
    }


}
