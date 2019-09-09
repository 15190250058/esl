package com.xbstar.esl.common;

import java.util.List;

/**
 * Created by Simon on 2019/9/9 13:39
 */
public abstract  class BaseServiceImpl<T> implements BaseService<T> {
    public abstract BaseMapper<T> getMapper();

    @Override
    public List<T> findAll() {
        return getMapper().selectAll();
    }

    @Override
    public int findCount(T t){
        return getMapper().selectCount(t);
    }

    @Override
    public T findById(Long id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public T findOne(T t){
       return getMapper().selectOne(t);
    }


    @Override
    public int insert(T t) {
        return getMapper().insert(t);
    }

    @Override
    public int update(T t) {
        return getMapper().updateByPrimaryKey(t);
    }

    @Override
    public int delete(Long id) {
        return getMapper().deleteByPrimaryKey(id);
    }

}
