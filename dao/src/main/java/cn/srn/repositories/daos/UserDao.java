package cn.srn.repositories.daos;

import cn.srn.repositories.entity.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Winter on 2016/4/22.
 */
@Repository
public interface UserDao extends BaseDao<User, Long> {
}
