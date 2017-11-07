package mapping;

import domain.User;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description: mapper接口，相当于DAO层
 * @Date:Created in 21:14 2017/11/7
 * @Modified By:
 */
public interface userMapper {

    public User getUser(int id) throws Exception;

    public List<User> findUserList(User user) throws Exception;
}
