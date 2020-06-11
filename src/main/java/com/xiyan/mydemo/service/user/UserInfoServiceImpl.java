package com.xiyan.mydemo.service.user;

import com.xiyan.mydemo.mapper.user.UserInfoMapper;
import com.xiyan.mydemo.pojo.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectList() {
        List<UserInfo> list=userInfoMapper.selectList();
        return list;
    }
}
