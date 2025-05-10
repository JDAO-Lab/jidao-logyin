package com.longYin.config;

import com.longYin.mapper.SysAdminMapper;
import com.longYin.mapper.SysConfigMapper;
import com.longYin.mapper.SysRulesMenuMapper;
import com.longYin.pojo.SysAdmin;
import com.longYin.pojo.SysRulesMenu;
import com.longYin.service.SysAdminService;
import com.longYin.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.List;
import java.util.Map;

@Configuration
public class GlobalConfig implements WebMvcConfigurer {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Autowired
    private SysAdminService sysAdminService;

    @Autowired
    private SysRulesMenuMapper sysRulesMenuMapper;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }

    class MyInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
            //获取系统配置信息
            List sysConfigObj = sysConfigMapper.getByAll();
            Map sys = TransUtils.convertToSysConfMap(sysConfigObj);
            request.setAttribute("sys", sys);
            //获取菜单名称信息，并设置title头
            String href = request.getRequestURI();
//            PrintUtils.print(href);
            // 只有后台自动更新title，前台调用前台菜单数据[不走这里，在前端过滤器中赋值菜单列表对象] api不设置[api菜单信息app端自定义配置，不通过管理系统设置]
            if (href.contains("/admin")) {
                // 如果包含/admin，执行相关操作
                SysRulesMenu menuObj = sysRulesMenuMapper.getMenuByHref(href);
                String title = "未定义页面名称";
                String menu_desc = "未定义页面描述信息";
//                PrintUtils.print(menuObj);
                if (menuObj!=null){
                    title = menuObj.getTitle();
                    menu_desc =  menuObj.getDescription();
                }
                request.setAttribute("title", title);
                request.setAttribute("menu_desc",menu_desc);
            }
            //获取用户信息
            String tokenName =  LoginConfig.getTokenName();
            String nowToken = CookiesUtils.getCookieValue(request, tokenName);
            if (nowToken!=null&&!nowToken.isEmpty()){
                SysAdmin userInfo = sysAdminService.getUserInfoByToken(nowToken);
                if (userInfo!=null){
                    Map userInfoMap = TransUtils.convertSysAdminToMap(userInfo);
                    request.setAttribute("userInfo",userInfoMap);
                }
            }
            return true;
        }
    }
}