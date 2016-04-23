package cn.srn.repositories.daos;

import cn.srn.repositories.entity.entities.Entity;

/**
 * Created by Winter on 2016/4/22.
 */
public interface BaseDao {

    long addEntity(Entity entity);
    long addEntities(Entity ... entity);
    Entity findOne(long id);
    long save(Entity entity);
    long deleteOne(long id);
}
