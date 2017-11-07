package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import util.MyBatisUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:L1ANN
 * @Description: 测试调用存储过程
 * @Date:Created in 22:48 2017/11/6
 * @Modified By:
 */
public class TestProcedure {
    @Test
    public void testGetUserCount(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        String statement = "mapping.userMapper.getUserCount";
        Map<String,Integer> parameterMap = new HashMap<>();
        parameterMap.put("sexid",1);
        parameterMap.put("usercount",-1);
        sqlSession.selectOne(statement,parameterMap);
        Integer result = parameterMap.get("usercount");
        System.out.println(result);
        sqlSession.close();
    }
}
