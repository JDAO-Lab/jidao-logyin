package com.longYin.service.impl;

import com.longYin.mapper.SysOrdersMapper;
import com.longYin.pojo.SysOrders;
import com.longYin.service.SysOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrdersServiceImpl implements SysOrdersService {

    @Autowired
    private SysOrdersMapper sysOrdersMapper;

    //根据条件查询数据
    public List<SysOrders> listByCondition(SysOrders sysOrders) {
        return sysOrdersMapper.listByCondition(sysOrders);
    }

}
