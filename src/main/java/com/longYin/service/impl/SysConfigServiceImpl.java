package com.longYin.service.impl;

import com.longYin.mapper.SysConfigMapper;
import com.longYin.pojo.SysConfig;
import com.longYin.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    public List<SysConfig> getAllSysConfigs() {
        return sysConfigMapper.getByAll();
    }

    public String getConfigValueByName(String name) {
        return sysConfigMapper.getConfigByName(name);
    }

    public boolean updateConfigValueByName(String name, String value) {
        return sysConfigMapper.updateConfigValueByName(name, value);
    }

}
