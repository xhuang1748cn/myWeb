package cn.srn.services;

import cn.srn.repositories.entity.entities.User;

/**
 * Created by SRn on 2016/4/23.
 */
public interface UserService {

    User findUserById(long id);
}
