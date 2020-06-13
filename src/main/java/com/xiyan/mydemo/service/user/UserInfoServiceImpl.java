package com.xiyan.mydemo.service.user;

import com.xiyan.mydemo.common.config.CustomException;
import com.xiyan.mydemo.common.utils.GenarateIdUtils;
import com.xiyan.mydemo.mapper.user.UserInfoMapper;
import com.xiyan.mydemo.pojo.user.UserInfo;
import com.xiyan.mydemo.vo.user.UserInfoInsertVO;
import com.xiyan.mydemo.vo.user.UserInfoUpdateVO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public int insertEntity(UserInfoInsertVO vo) {
        if (userInfoMapper.existByUserName(vo.getUsername())) {
            throw new CustomException("用户名(" + vo.getUsername() + ")已被注册");
        }
        String salt = randomSalt();
        UserInfo entity = UserInfo.builder().userId(GenarateIdUtils.getUserId()).username(vo.getUsername())
                .salt(salt).password(encryptPassword(vo.getUsername(), vo.getPassword(), salt)).build();
        return userInfoMapper.insertEntity(entity);
    }

    @Override
    public int deleteByUserId(Long userId) {
        return userInfoMapper.deleteByUserId(userId);
    }

    @Override
    public int updateEntity(UserInfoUpdateVO vo) {
        UserInfo oldEntity=userInfoMapper.selectEntityByUserId(vo.getUserId());
        if(Objects.isNull(oldEntity)){
            throw new CustomException("不存在该用户");
        }
        if(!matches(oldEntity.getUsername(),oldEntity.getPassword(),oldEntity.getSalt(),vo.getPassword())){
            throw new CustomException("原密码不匹配");
        }
        UserInfo entity = dozerMapper.map(oldEntity,UserInfo.class);
        entity.setCreateTime(oldEntity.getCreateTime());
        String salt = randomSalt();
        entity.setSalt(salt);
        entity.setPassword(encryptPassword(vo.getUsername(), vo.getPassword(), salt));
        return userInfoMapper.updateEntity(entity);
    }

}
