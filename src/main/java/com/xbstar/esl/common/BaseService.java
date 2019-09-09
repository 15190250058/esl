package com.xbstar.esl.common;

import java.util.List;

/**
 * Created by Simon on 2019/9/9 13:38
 */
public interface BaseService<T> {
    List<T> findAll();

    int findCount(T t);

    T findById(Long id);

    T findOne(T t);

    int insert(T t);

    int update(T t);

    int delete(Long id);
}
