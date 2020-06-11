package com.xiyan.mydemo.controller;

import com.xiyan.mydemo.common.utils.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "api接口访问测试")
@RequestMapping("/api/test")
@RestController
public class ApiTestController {

    @ApiOperation(value="成功返参", notes="测试操作成功")
    @GetMapping
    public ApiResult success(){
        return ApiResult.success();
    }

    @ApiOperation(value="错误返参", notes="测试操作失败")
    @PostMapping
    @ResponseBody
    public ApiResult error(){
        return ApiResult.error("错误信息");
    }
}
