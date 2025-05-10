package com.longYin.controller.api;

import com.longYin.constant.ApiConstant;
import com.longYin.controller.BaseController;
import com.longYin.pojo.result.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstant.PATH_PREFIX)
public class ApiClientController extends BaseController {
    @GetMapping("/test")
    public Result test(){
        return Result.success("测试Get接口，默认返回信息！");
    }

    @PostMapping("/test")
    public Result testPost(){
        return Result.success("测试Post接口，默认返回信息！");
    }

    @PutMapping("/test")
    public Result testPut(){
        return Result.success("测试Put接口，默认返回信息！");
    }

    @DeleteMapping("/test")
    public Result testDelete(){
        return Result.success("测试Delete接口，默认返回信息！");
    }
}
