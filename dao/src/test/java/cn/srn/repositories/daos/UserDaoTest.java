package cn.srn.repositories.daos;

import cn.srn.repositories.entity.entities.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by SRn on 2016/4/23.
 */
public class UserDaoTest extends BaseDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findOneTest() {
        User user = (User) userDao.findOne(1);
        System.out.println(user.toString());
    }
}