package com.longYin.service.impl;

import com.longYin.mapper.AppVersionMapper;
import com.longYin.pojo.AppVersion;
import com.longYin.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Autowired
    private AppVersionMapper appVersionMapper;

    //根据条件查询数据
    public List<AppVersion> listByCondition(AppVersion appVersion) {
        return appVersionMapper.listByCondition(appVersion);
    }

    //保存数据
    public boolean save(AppVersion appVersion) {
        return appVersionMapper.save(appVersion);
    }

    //根据id获取数据
    public AppVersion getById(Integer id) {
        return appVersionMapper.getById(id);
    }

    //更新数据
    public boolean update(AppVersion appVersion) {
        return appVersionMapper.update(appVersion);
    }

    //删除
    public boolean remove(Integer id) {
        return appVersionMapper.remove(id);
    }

    //批量删除
    public boolean removeBatch(List<Integer> ids) {
        return appVersionMapper.removeBatch(ids);
    }

    //恢复
    public boolean recovery(Integer id) {
        return appVersionMapper.recovery(id);
    }

    //批量恢复
    public boolean recoveryBatch(List<Integer> ids) {
        return appVersionMapper.recoveryBatch(ids);
    }

}
