package com.longYin.controller.admin;

import com.longYin.config.LoginConfig;
import com.longYin.constant.AdminConstant;
import com.longYin.controller.BaseController;
import com.longYin.pojo.SysAdmin;
import com.longYin.pojo.result.Result;
import com.longYin.service.SysAdminService;
import com.longYin.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(AdminConstant.PATH_PREFIX)
public class AdminLoginController extends BaseController {

    private static String MODULE_PATH = AdminConstant.MODULE_PATH;

    private String tokenName =  LoginConfig.getTokenName();

    @Autowired
    private SysAdminService sysAdminService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/login")
    public ModelAndView showLoginPage(ModelAndView model,HttpServletRequest request){
        //读取系统配置中的加密字串，如果不匹配则默认跳转到前台
        Map sys = (Map) request.getAttribute("sys");
        // 获取系统配置中的 admin_key
        String adminKeyStr = (String) sys.get("admin_key");
        if (!adminKeyStr.isEmpty()){
            String adminKey = MD5Util.md5(adminKeyStr);
            String inputKey = request.getParameter("k"); // 从请求参数中获取输入的 key
            // 默认如果 adminKey 为空则不进行匹配验证
            if (adminKey != null && !adminKey.equals(inputKey)) {
                //跳转到首页
                return new ModelAndView("redirect:/?waring=login");
            }
        }
        //读取系统配置信息，获取标题并组成管理系统的title
        model.setViewName(MODULE_PATH+"login");
        return model;
    }

    //登录请求处理
    @PostMapping("/login")
    public Result loginProcess(@RequestParam String username, @RequestParam String password, @RequestParam(required = false,defaultValue = "0") Integer remember, HttpServletResponse response){

        // 处理登录逻辑，比如验证用户名和密码
        if (username==null || username.trim().isEmpty())
        {
            return Result.error("用户名不得为空！");
        }
        if (password==null || password.trim().isEmpty())
        {
            return Result.error("密码不得为空！");
        }
        //如果都不为空则执行登录
        if (password!=null&&username!=null){
            String numberToken = MD5Util.md5("pwd_error_name_"+username);
            //输入错误超过5次则停止登录2小时
            Integer loginErrNum = 0;
            Integer loginErrMaxNum = LoginConfig.getErrLockNum();
            String loginErrNumString = redisUtil.getValue(numberToken);
            Integer loginErrHour = LoginConfig.getErrLockHour();
            Integer loginErrTimeout = loginErrHour*3600;
            if (loginErrNumString!=null){
                loginErrNum = Integer.parseInt(loginErrNumString);
                if (loginErrNum>=loginErrMaxNum){
                    return Result.error(String.format("密码错误已超%d次,%d小时后可重试!", loginErrMaxNum,loginErrHour));
                }
            }
            String encryptedPassword = MD5Util.md5(password); // 加密后的密码
            System.out.println(encryptedPassword); // 输出加密后的密码
            SysAdmin sysLoginData = sysAdminService.loginAuthSql(username,encryptedPassword);
            if (sysLoginData!=null){
                System.out.print(sysLoginData);
                if (sysLoginData.getIsDeleted()>0||sysLoginData.getEnable()<1){
                    return Result.error("用户已被禁止或删除！");
                }
                //默认过期时间为12小时
                Integer timeOut = LoginConfig.getLoginTimeout();
                Long expire = LoginConfig.getLoginJwtExpire();
                if (remember>0){
                    //选中后默认时间为30天
                    Integer remeberDay = LoginConfig.getRemeberDay();
                    timeOut = 2*timeOut*remeberDay;
                    expire = 2*expire*remeberDay; // 过期时间为30天，单位为毫秒
                }
                //组成登录数据
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", sysLoginData.getId());
                claims.put("username", sysLoginData.getUsername());
                claims.put("rule_id", sysLoginData.getRuleId());
                claims.put("is_deleted",sysLoginData.getIsDeleted());
                claims.put("avatar",sysLoginData.getAvatar());
                //生成jwt令牌
                String jwt = JwtUtils.generateJwt(claims,expire);
                //MD5加密更新用户token，验证时将cookies中的jwt进行加密匹配数据
                String newToken = MD5Util.md5(jwt);
                //更新数据
                sysAdminService.loginUpDate(sysLoginData.getId(),newToken);
                //以token为name进行存储到redis数据中
                String jsonString = JsonUtils.objectToJson(sysLoginData);
                PrintUtils.print("用户登录中..."+newToken);
//                PrintUtils.print(jsonString);
                redisUtil.setValue(newToken,jsonString);
                redisUtil.setValue(numberToken,"0",loginErrTimeout);
                CookiesUtils.setCookie(tokenName,newToken,timeOut,response);
                return Result.success("登录成功",newToken);
            }
            //记录用户名输入错误数
            Integer nowLoginErrNum = loginErrNum+1;
            redisUtil.setValue(numberToken,Integer.toString(nowLoginErrNum),loginErrTimeout);
            return  Result.error("用户名或密码错误！");
        }
        // 假设登录成功后返回的 JSON 数据
        return Result.error("密码错误！");
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletResponse response, HttpServletRequest request){
        String nowToken = CookiesUtils.getCookieValue(request, tokenName);
        redisUtil.deleteKey(nowToken); // 销毁redis
        CookiesUtils.destroyCookie(request, response, tokenName); // 销毁cookies
        // 使用RedirectView进行重定向
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/"); // 设置重定向的URL
        redirectView.setExposeModelAttributes(false); // 不暴露模型属性
        return redirectView;
    }

}