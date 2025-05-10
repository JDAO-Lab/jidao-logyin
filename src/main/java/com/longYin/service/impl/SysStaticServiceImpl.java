package com.longYin.service.impl;

import com.longYin.mapper.SysStaticMapper;
import com.longYin.pojo.SysStatic;
import com.longYin.service.SysStaticService;
import com.longYin.utils.DateUtils;
import com.longYin.utils.PrintUtils;
import com.longYin.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class SysStaticServiceImpl implements SysStaticService {

    @Autowired
    private SysStaticMapper sysStaticMapper;

    public boolean save(SysStatic sysStatic){
        return sysStaticMapper.save(sysStatic);
    }

    public boolean update(SysStatic sysStatic){
        return sysStaticMapper.update(sysStatic);
    }

    public int searchByNameAndTypeInToady(Integer type, Map<String,String> startDateAndEndTime){
        String startDateTimeStr = startDateAndEndTime.get("start");
        String endDateTimeStr = startDateAndEndTime.get("end");
        String format = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime startDate = DateUtils.parseDateTime(startDateTimeStr, format);
        LocalDateTime endDate = DateUtils.parseDateTime(endDateTimeStr, format);
//        PrintUtils.print("startDate:"+startDate+",endDate:"+endDate);
        return sysStaticMapper.searchByNameAndTypeInToady(type,startDate,endDate);
    }

    public double getTypeValueByDateRange(Integer type,Map<String,String> startDateAndEndTime){
        String startDateTimeStr = startDateAndEndTime.get("start");
        String endDateTimeStr = startDateAndEndTime.get("end");
        String format = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime startDate = DateUtils.parseDateTime(startDateTimeStr, format);
        LocalDateTime endDate = DateUtils.parseDateTime(endDateTimeStr, format);
//        PrintUtils.print("startDate:"+startDate+",endDate:"+endDate);
        return sysStaticMapper.getTypeValueByDateRange(type,startDate,endDate);
    }

    public double sumTypeValue(Integer type){
        return sysStaticMapper.sumTypeValue(type);
    }

    public List<SysStatic> listByCondition(Integer type,Map<String,String> startDateAndEndTime){
        String startDateTimeStr = startDateAndEndTime.get("start");
        String endDateTimeStr = startDateAndEndTime.get("end");
        String format = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime startDate = StringUtils.isEmpty(startDateTimeStr) ? null : DateUtils.parseDateTime(startDateTimeStr, format);
        LocalDateTime endDate = StringUtils.isEmpty(endDateTimeStr) ? null : DateUtils.parseDateTime(endDateTimeStr, format);
        return sysStaticMapper.listByCondition(type,startDate,endDate);
    }

}
