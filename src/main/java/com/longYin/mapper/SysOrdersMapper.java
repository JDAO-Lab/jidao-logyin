package com.longYin.mapper;

import com.longYin.mapper.provider.SysOrdersProvider;
import com.longYin.pojo.SysOrders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysOrdersMapper {

    //根据条件查询数据
    @SelectProvider(type = SysOrdersProvider.class,method = "listByCondition")
    List<SysOrders> listByCondition(SysOrders sysOrders);

}
