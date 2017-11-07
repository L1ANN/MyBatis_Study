package test;

import domain.Order;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import util.MyBatisUtil;

/**
 * @Author:L1ANN
 * @Description: 为了测试 解决实体类属性名和SQL字段名产生的冲突
 * @Date:Created in 20:12 2017/11/1
 * @Modified By:
 */
public class TestOrder {

    @Test
    public void testGetOrderId(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //映射sql的标识字符串
        String statement = "mapping.orderMapper.getOrderById";
        //执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement,1);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(order);  //打印结果：null，也就是没有查询出相应的记录
    }

    @Test
    public void testGetOrderById2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //映射sql的标识字符串
        String statement = "mapping.orderMapper.selectOrder";
        //执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement,1);
        //执行查询操作，将查询结果自动封装成Order对象返回
        sqlSession.close();
        System.out.println(order);
    }

    @Test
    public void testGetOrderById3(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //映射sql的标识字符串
        String statement = "mapping.orderMapper.selectOrderResultMap";
        //执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement,1);
        System.out.println(order);
    }
}
