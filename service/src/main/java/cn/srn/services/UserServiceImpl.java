package cn.srn.services;

import cn.srn.repositories.daos.UserDao;
import cn.srn.repositories.entity.entities.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo<User> findAll() {
        PageHelper.startPage(1, 3);
        List<User> users = userDao.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }


}
