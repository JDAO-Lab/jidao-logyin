package com.longYin.mapper.provider;

import com.longYin.pojo.SysOrders;
import org.apache.ibatis.jdbc.SQL;

public class SysOrdersProvider {
    //根据条件查询数据
    public String listByCondition(SysOrders sysOrders) {
        return new SQL(){{
            SELECT("*");
            FROM("sys_orders");
            if (sysOrders.getRemarks() != null) {
                WHERE("remarks like  CONCAT('%', #{remarks}, '%')");
            }
            if (sysOrders.getOutTradeNo() != null ) {
                WHERE("out_trade_no like CONCAT('%', #{outTradeNo}, '%')");
            }
            if (sysOrders.getTradeNo() != null) {
                WHERE("trade_no like CONCAT('%', #{tradeNo}, '%')");
            }
            ORDER_BY("id DESC");
        }}.toString();
    }
}
