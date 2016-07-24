package cn.srn.services;

import cn.srn.repositories.entity.entities.User;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

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

    @Test
    public void testFindAll() throws Exception {
        PageInfo<User> users = userService.findAll();
        System.out.println(users);
        for (User user : users.getList()) {
            System.out.println(user);
        }
    }

}