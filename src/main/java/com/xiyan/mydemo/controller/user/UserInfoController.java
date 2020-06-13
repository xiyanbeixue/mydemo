package com.xiyan.mydemo.controller.user;

import com.xiyan.mydemo.common.utils.ApiResult;
import com.xiyan.mydemo.pojo.user.UserInfo;
import com.xiyan.mydemo.service.user.UserInfoService;
import com.xiyan.mydemo.vo.user.UserInfoInsertVO;
import com.xiyan.mydemo.vo.user.UserInfoUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @ApiOperation(value = "添加用户", notes = "所有字段必传")
    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody UserInfoInsertVO vo) {
        userInfoService.insertEntity(vo);
        return ApiResult.success();
    }

    @ApiOperation(value = "根据userId删除用户", notes = "userId必填")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户userId")
    })
    @DeleteMapping("/delete")
    public ApiResult delete(Long userId){
        userInfoService.deleteByUserId(userId);
        return ApiResult.success();
    }

    @ApiOperation(value = "更新用户", notes = "所有字段必传")
    @PutMapping("/update")
    public ApiResult update(@Valid @RequestBody UserInfoUpdateVO vo){
        userInfoService.updateEntity(vo);
        return ApiResult.success();
    }

}
