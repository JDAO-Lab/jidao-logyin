package com.longYin.mapper;

import com.longYin.pojo.WebUsersVipser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WebUsersVipserMapper {

    //根据uid获取会员信息
    @Select("select v.*,i.name as income_text from web_users_vipser as v  left join web_income as i on i.id=v.income_id  where v.uid=#{uid} ")
    WebUsersVipser getByUid(@Param("uid") Integer uid);
}
