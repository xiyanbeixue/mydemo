package com.xiyan.mydemo.vo.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author xiyan
 * @Date 2020/6/11
 * @Version 1.0
 */
@Data
public class UserInfoVO implements Serializable {
    private static final long SerialVersionUID=1l;
    private String username;
    private String password;
}
