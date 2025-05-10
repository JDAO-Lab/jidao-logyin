package com.longYin.service;

import com.longYin.pojo.SysOrders;

import java.util.List;

public interface SysOrdersService {

    //根据条件查询数据
    List<SysOrders> listByCondition(SysOrders sysOrders);

}
