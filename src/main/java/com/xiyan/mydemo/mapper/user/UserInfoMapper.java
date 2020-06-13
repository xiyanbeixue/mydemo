package com.xiyan.mydemo.mapper.user;

import com.xiyan.mydemo.pojo.user.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {
    List<UserInfo> selectList();

    int insertEntity(UserInfo entity);

    boolean existByUserName(String username);

    int deleteByUserId(Long userId);

    int updateEntity(UserInfo entity);

    UserInfo selectEntityByUserId(Long userId);
}
