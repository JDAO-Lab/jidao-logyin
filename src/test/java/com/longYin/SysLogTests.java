package com.longYin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longYin.pojo.SysLog;
import com.longYin.service.SysLogService;
import com.longYin.utils.PrintUtils;
import com.longYin.utils.SysLogUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class SysLogTests {
    @Autowired
    private SysLogUtils sysLogUtils;

    @Autowired
    private SysLogService sysLogService;

    @Test
    public void testSaveLog(){
        sysLogUtils.saveLog("测试单元:testSaveLog lucky",0);
    }

    @Test
    public void testGetLog(){
        SysLog sysLog = new SysLog();
        List<SysLog> logs = sysLogService.list(sysLog);
        PrintUtils.print(logs);
    }


}
