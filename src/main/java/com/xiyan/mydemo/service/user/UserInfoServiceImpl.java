package com.xiyan.mydemo.service.user;

import com.xiyan.mydemo.common.config.CustomException;
import com.xiyan.mydemo.common.utils.GenarateIdUtils;
import com.xiyan.mydemo.common.utils.RegexUtils;
import com.xiyan.mydemo.mapper.user.UserInfoMapper;
import com.xiyan.mydemo.pojo.user.UserInfo;
import com.xiyan.mydemo.vo.user.UserInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired(required = false)
    private Mapper dozerMapper;

    @Override
    public List<UserInfo> selectList() {
        List<UserInfo> list = userInfoMapper.selectList();
        return list;
    }

    @Override
    public int insertEntity(UserInfoVO vo) {
        if (StringUtils.isBlank(vo.getUsername()) || StringUtils.isBlank(vo.getPassword())) {
            throw new RuntimeException("用户名或密码不能为空");
        }
        if(!RegexUtils.checkUsername(vo.getUsername())){
            throw new CustomException(RegexUtils.REGEX_USERNAME_ERROR);
        }
        if(!RegexUtils.checkPasswprd(vo.getPassword())){
            throw new RuntimeException(RegexUtils.REGEX_PASSWORD_ERROR);
        }
        if(userInfoMapper.selectOneByUserName(vo.getUsername())){
            throw new RuntimeException("用户名("+vo.getUsername()+")已被注册");
        }
        String salt = randomSalt();
        UserInfo entity = UserInfo.builder().userId(GenarateIdUtils.getUserId()).username(vo.getUsername())
                .salt(salt).password(encryptPassword(vo.getUsername(), vo.getPassword(), salt)).build();
        return userInfoMapper.insertEntity(entity);
    }

}
