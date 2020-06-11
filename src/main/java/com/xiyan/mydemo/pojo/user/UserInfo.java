package com.xiyan.mydemo.pojo.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private String username;
    private String password;
    private String salt;
    private Date createTime;
}
