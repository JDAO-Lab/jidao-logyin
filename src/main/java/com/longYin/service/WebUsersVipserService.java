package com.longYin.service;


import com.longYin.pojo.WebUsersVipser;

public interface WebUsersVipserService {

    //根据uid获取会员数据
    WebUsersVipser getByUid(Integer uid);

}
