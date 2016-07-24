package cn.srn.repositories.daos;

import cn.srn.repositories.entity.entities.Entity;

import java.util.List;

/**
 * Created by Winter on 2016/4/22.
 */
public interface BaseDao<T, Key> {

    long addEntity(Entity entity);
    long addEntities(Entity ... entity);
    Entity findOne(Key id);
    long save(Entity entity);
    long deleteOne(Key id);
    List<T> findAll();
}
