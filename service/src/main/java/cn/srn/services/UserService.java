package cn.srn.services;

import cn.srn.repositories.entity.entities.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by SRn on 2016/4/23.
 */
public interface UserService {

    User findUserById(long id);

    PageInfo<User> findAll();
}
