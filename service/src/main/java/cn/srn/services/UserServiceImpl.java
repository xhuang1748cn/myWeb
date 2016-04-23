package cn.srn.services;

import cn.srn.repositories.daos.UserDao;
import cn.srn.repositories.entity.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SRn on 2016/4/23.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(long id) {
        return (User) userDao.findOne(id);
    }
}
