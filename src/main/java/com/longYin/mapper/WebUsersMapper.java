package com.longYin.mapper;

import com.longYin.mapper.provider.WebUsersProvider;
import com.longYin.pojo.WebUsers;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WebUsersMapper {

    //查询所有数据
    @Select("select * from web_users")
    List<WebUsers> list();

    //根据id获取详情数据
    @Select("select * from web_users where id=#{id}")
    WebUsers getById(@Param("id") Integer id);

    //根据条件查询数据
    @SelectProvider(type = WebUsersProvider.class, method = "listByCondition")
    List<WebUsers> listByCondition(WebUsers webUsers);

    //更新数据
    @UpdateProvider(type = WebUsersProvider.class, method = "update")
    boolean update(WebUsers webUsers);

    //批量禁用
    @UpdateProvider(type = WebUsersProvider.class, method = "disableBatch")
    boolean disableBatch(List<Integer> ids);

    //批量启用
    @UpdateProvider(type = WebUsersProvider.class, method = "enableBatch")
    boolean enableBatch(List<Integer> ids);

}
