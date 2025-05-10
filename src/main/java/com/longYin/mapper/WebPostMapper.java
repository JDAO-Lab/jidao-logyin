package com.longYin.mapper;

import com.longYin.mapper.provider.WebPostProvider;
import com.longYin.pojo.WebPost;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WebPostMapper {

    //根据条件查询
    @SelectProvider(type = WebPostProvider.class, method = "listByCondition")
    List<WebPost> listByCondition(WebPost webPost);

    //回收站列表查询
    @SelectProvider(type = WebPostProvider.class, method = "listByConditionRecovery")
    List<WebPost> listByConditionRecovery(WebPost webPost);

    //保存数据
    @Insert("insert into web_post(cid,title,keywords,description,content,views,created_at) values(#{cid},#{title},#{keywords},#{description},#{content},#{views},#{createdAt})")
    boolean save(WebPost webPost);

    //根据id获取数据
    @Select("select * from web_post where id=#{id}")
    WebPost getById(Integer id);

    //更新数据
    @UpdateProvider(type = WebPostProvider.class, method = "update")
    boolean update(WebPost webPost);

    //删除
    @Update("update web_post set is_deleted=1 where id=#{id}")
    boolean remove(Integer id);

    //批量删除
    @UpdateProvider(type = WebPostProvider.class, method = "removeBatch")
    boolean removeBatch(List<Integer> ids);

    //彻底删除
    @Update("update web_post set is_deleted=2 where id=#{id}")
    boolean removed(Integer id);

    //恢复
    @Update("update web_post set is_deleted=0 where id=#{id}")
    boolean recovery(Integer id);

    //批量恢复
    @UpdateProvider(type = WebPostProvider.class, method = "recoveryBatch")
    boolean recoveryBatch(List<Integer> ids);

    //阅读增加
    @Update("update web_post set views=views+1 where id=#{id}")
    boolean views(Integer id);

}
