package com.longYin.service.impl;

import com.longYin.mapper.WebPostMapper;
import com.longYin.pojo.WebPost;
import com.longYin.service.WebPostRecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebPostRecoveryServiceImpl implements WebPostRecoveryService {

    @Autowired
    private WebPostMapper webPostMapper;


    //回收站列表查询
    public List<WebPost> listByCondition(WebPost webPost) {
        return webPostMapper.listByConditionRecovery(webPost);
    }

    //删除
    public boolean remove(Integer id) {
        return webPostMapper.removed(id);
    }

    //恢复
    public boolean recovery(Integer id) {
        return webPostMapper.recovery(id);
    }

    //批量恢复
    public boolean recoveryBatch(List<Integer> ids) {
        return webPostMapper.recoveryBatch(ids);
    }

}
