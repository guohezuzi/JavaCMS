package data;

import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: guohezuzi
 * \* Date: 2018-04-09
 * \* Time: 下午5:32
 * \* Description:user数据库操作
 * \
 */

public interface UserRepository {
    //根据用户名查找密码
    public String findPassByName(String name);
}
