package com.longYin.controller.home;

import com.longYin.constant.HomeConstant;
import com.longYin.controller.BaseController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(HomeConstant.PATH_PREFIX)
public class HomeIndexController extends BaseController {

    private static String MODULE_PATH = HomeConstant.MODULE_PATH;

    //首页
    @GetMapping("/")
    public ModelAndView index(ModelAndView model){
        saveSysLog("访问了首页",1);
        analysis(0,1);
        // 加入一个属性，用来在模板中读取
        model.addObject("title", "距离成功又近了~");
        model.addObject("message", "本通用管理系统，为基线开发系统，基于Java11，maven3.6.1管理依赖，涵盖常见的后台管理能力，能够快速投入开发工作使用~~");
        model.setViewName(MODULE_PATH+"index");
        return model;
    }



}
