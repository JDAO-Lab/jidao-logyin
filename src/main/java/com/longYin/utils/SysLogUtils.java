package com.longYin.utils;

import com.longYin.pojo.SysLog;
import com.longYin.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class SysLogUtils {

    @Autowired
    private IPUtil ipUtil;
    @Autowired
    private SysLogService sysLogService;

    public void saveLog(String remarks,Integer result){
        String ip = ipUtil.getIpAddress();
//        PrintUtils.print("ip:"+ip);
        String path = ipUtil.getRequestUrl();
        String method = ipUtil.getMethod();
//        PrintUtils.print("path"+path);
        SysLog sysLog = new SysLog();
        sysLog.setIp(ip);
        sysLog.setPath(path);
        sysLog.setMethod(method);
        sysLog.setCreatedAt(new Date());
        sysLog.setResult(result);
        sysLog.setRemarks(remarks);
        sysLogService.addSysLog(sysLog);
    }

}
