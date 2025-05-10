package com.longYin.service.impl;

import com.longYin.mapper.WebUsersMapper;
import com.longYin.pojo.WebUsers;
import com.longYin.service.WebUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebUsersServiceImpl implements WebUsersService {

    @Autowired
    private WebUsersMapper webUsersMapper;

    public List<WebUsers> list(){
        return webUsersMapper.list();
    }

    public WebUsers getById(Integer id){
        return webUsersMapper.getById(id);
    }

    public List<WebUsers> listByCondition(WebUsers webUsers){
        return webUsersMapper.listByCondition(webUsers);
    }

    public boolean update(WebUsers webUsers){
        return webUsersMapper.update(webUsers);
    }

    public boolean enableBatch(List<Integer> ids){
        return webUsersMapper.enableBatch(ids);
    }

    public boolean disableBatch(List<Integer> ids){
        return webUsersMapper.disableBatch(ids);
    }

}
