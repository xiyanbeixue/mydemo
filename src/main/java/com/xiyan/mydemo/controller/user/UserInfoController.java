package com.xiyan.mydemo.controller.user;

import com.xiyan.mydemo.common.utils.ApiResult;
import com.xiyan.mydemo.pojo.user.UserInfo;
import com.xiyan.mydemo.service.user.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@Api(tags = "用户相关接口")
@RequestMapping("/api/user")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value="获取用户列表")
    @GetMapping("/list")
    public ApiResult list(){
        List<UserInfo> list= userInfoService.selectList();
        return ApiResult.success(list);
    }
}
