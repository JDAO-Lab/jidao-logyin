package com.longYin.service.impl;

import com.longYin.mapper.WebUsersVipserMapper;
import com.longYin.pojo.WebUsersVipser;
import com.longYin.service.WebUsersVipserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebUsersVipserServiceImpl  implements WebUsersVipserService {

    @Autowired
    private WebUsersVipserMapper webUsersVipserMapper;

    public WebUsersVipser getByUid(Integer uid) {
        return webUsersVipserMapper.getByUid(uid);
    }

}
