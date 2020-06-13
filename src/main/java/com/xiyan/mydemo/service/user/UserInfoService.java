package com.xiyan.mydemo.service.user;

import com.xiyan.mydemo.pojo.user.UserInfo;
import com.xiyan.mydemo.vo.user.UserInfoInsertVO;
import com.xiyan.mydemo.vo.user.UserInfoUpdateVO;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.List;
import java.util.Objects;

public interface UserInfoService {
    List<UserInfo> selectList();

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

    /**
     * 新旧密码匹配
     * @param username 原用户名
     * @param password 原密码
     * @param salt 原随机盐
     * @param inputPassword 需验证的密码
     * @return
     */
    default boolean matches(String username,String password,String salt,String inputPassword){
        return Objects.equals(password,encryptPassword(username,inputPassword,salt));
    }

    int insertEntity(UserInfoInsertVO vo);

    int deleteByUserId(Long userId);

    int updateEntity(UserInfoUpdateVO vo);
}
