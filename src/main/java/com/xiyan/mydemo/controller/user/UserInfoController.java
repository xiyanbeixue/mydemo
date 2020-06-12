package com.xiyan.mydemo.controller.user;

import com.xiyan.mydemo.common.utils.ApiResult;
import com.xiyan.mydemo.pojo.user.UserInfo;
import com.xiyan.mydemo.service.user.UserInfoService;
import com.xiyan.mydemo.vo.user.UserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@Api(tags = "用户相关接口")
@RequestMapping("/api/user")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;


    @ApiOperation(value = "获取用户列表")
    @GetMapping("/list")
    public ApiResult list() {
        List<UserInfo> list = userInfoService.selectList();
        return ApiResult.success(list);
    }

    @ResponseBody
    @ApiOperation(value = "添加用户")
    @PostMapping("/add")
    private ApiResult add(UserInfoVO vo) {
        userInfoService.insertEntity(vo);
        return ApiResult.success();
    }
}
