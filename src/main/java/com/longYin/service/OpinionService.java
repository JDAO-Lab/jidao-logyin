package com.longYin.service;

import com.longYin.pojo.Opinion;

import java.util.List;

public interface OpinionService {

    //更新
    boolean update(Opinion opinion);

    //根据条件查询数据
    List<Opinion> listByCondition(Opinion opinion);

    //根据id读取数据
    Opinion getById(Integer id);

    //批量删除
    boolean removeBatch(List<Integer> ids);

}
