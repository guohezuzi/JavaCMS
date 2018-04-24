package data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: guohezuzi
 * \* Date: 2018-04-23
 * \* Time: 下午3:11
 * \* Description:
 * \
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final String FIND_PASS_BY_NAME="SELECT password FROM admin WHERE name=?";
    private final JdbcOperations jdbcOperations;

    @Autowired
    public UserRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public String findPassByName(String name) {
        try {
            return jdbcOperations.queryForObject(FIND_PASS_BY_NAME,String.class,name);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
