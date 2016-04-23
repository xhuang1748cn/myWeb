package cn.srn.services;

import cn.srn.repositories.entity.entities.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by SRn on 2016/4/23.
 */
public class UserServiceTest extends BaseServiceTest {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Test
    public void testFindUserById() {
        User user = userService.findUserById(1);
        System.out.println(user.toString());
    }
}