package com.longYin.service.impl;

import com.longYin.mapper.WebNavMapper;
import com.longYin.pojo.WebNav;
import com.longYin.service.WebNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebNavServiceImpl implements WebNavService {

    @Autowired
    private WebNavMapper webNavMapper;

    //根据条件查询
    public List<WebNav> listByCondition(WebNav webNav) {
        return webNavMapper.listByCondition(webNav);
    }

    //统计总数
    public Integer countByPid(Integer id) {
        return webNavMapper.countByPid(id);
    }

    //统计总数
    public Integer countByPids(List<Integer> ids) {
        return webNavMapper.countByPids(ids);
    }

    //获取顶级菜单数据
    public List<WebNav> getTopMenu(Integer cid) {
        return webNavMapper.getTopMenu(cid);
    }

    //根据id获取数据
    public WebNav getById(Integer id) {
        return webNavMapper.getById(id);
    }

    //保存数据
    public boolean save(WebNav webNav) {
        return webNavMapper.save(webNav);
    }

    //删除
    public boolean remove(Integer id) {
        return webNavMapper.remove(id);
    }

    //批量删除
    public boolean removeBatch(List<Integer> ids) {
        return webNavMapper.removeBatch(ids);
    }

    //更新
    public boolean update(WebNav webNav) {
        return webNavMapper.update(webNav);
    }

}
