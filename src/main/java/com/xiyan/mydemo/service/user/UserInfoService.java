package com.xiyan.mydemo.service.user;

import com.xiyan.mydemo.pojo.user.UserInfo;
import com.xiyan.mydemo.vo.user.UserInfoVO;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> selectList();

    int insertEntity(UserInfoVO vo);

    /**
     * 生成随机盐
     */
    default String randomSalt()
    {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        return secureRandom.nextBytes(3).toHex();
    }

    /**
     * 新旧密码匹配
     * @param user
     * @param newPassword
     * @return
     */
//    default boolean matches(User user, String newPassword)
//    {
//        return user.getPassword().equals(encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
//    }

    /**
     * 密码加密
     * @param username
     * @param password
     * @param salt
     * @return
     */
    default String encryptPassword(String username, String password, String salt)
    {
        return new Md5Hash(username + password + salt).toHex().toString();
    }
}
