package com.longYin.controller;

import com.longYin.enums.StaticTypeEnum;
import com.longYin.utils.SysLogUtils;
import com.longYin.utils.SysStaticUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class BaseController {
    @Autowired
    private SysLogUtils sysLogUtils;

    @Autowired
    private HttpServletRequest breq;

    @Autowired
    private SysStaticUtil sysStaticUtil;

    //记录统计数据 type对应参数请在枚举中查看
    public void analysis(Integer type,double value)
    {
        String name = StaticTypeEnum.getByCode(type).getValue();
        sysStaticUtil.analysis(type,name,value);
    }

    //获取当前用户数据
    public Object getUserInfo(){
        Map userInfo = (Map) breq.getAttribute("userInfo");
        return userInfo;
    }

    //获取当前用户的id
    public int getUserId(){
        Map userInfo = (Map) breq.getAttribute("userInfo");
        Integer id = Integer.parseInt((String) userInfo.get("id"));
        return id;
    }

    //存入系统日志
    public void saveSysLog(String remarks,Integer result) {
        sysLogUtils.saveLog(remarks,result);
    }
}
