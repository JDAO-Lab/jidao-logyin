package com.longYin.mapper.provider;

import com.longYin.pojo.WebNavCat;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.stream.Collectors;

public class WebNavCatProvider {

    // 条件查询
    public String listByCondition(WebNavCat webNavCat) {
        return new SQL(){{
            SELECT("*"); // 多条件查询
            FROM("web_nav_cat");
            if (webNavCat.getName() != null ) {
                WHERE("name like CONCAT('%', #{name}, '%')");
            }
            ORDER_BY("updated_at DESC");
        }}.toString();
    }

    // 更新数据
    public String update(WebNavCat webNavCat) {
        return new SQL(){{
            UPDATE("web_nav_cat");
            if (webNavCat.getName() != null) {
                SET("name = #{name}");
            }
            if (webNavCat.getDescription() != null) {
                SET("description = #{description}");
            }
            if (webNavCat.getIsDeleted() != null) {
                SET("is_deleted = #{isDeleted}");
            }
            if (webNavCat.getUpdatedAt() != null) {
                SET("updated_at = #{updatedAt}");
            }
            if (webNavCat.getCreatedAt() != null) {
                SET("created_at = #{createdAt}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }

    //批量删除
    public String removeBatch(List<Integer> ids) {
        String idStr = ids.stream().map(String::valueOf).collect(Collectors.joining(","));
        return new SQL() {{
            UPDATE("web_nav_cat");
            SET("is_deleted = 1");
            WHERE("id IN (" + idStr + ")");
        }}.toString();
    }

    //批量恢复
    public String recoveryBatch(List<Integer> ids) {
        String idStr = ids.stream().map(String::valueOf).collect(Collectors.joining(","));
        return new SQL(){{
            UPDATE("web_nav_cat");
            SET("is_deleted = 0");
            WHERE("id IN (" + idStr + ")");
        }}.toString();
    }

}
