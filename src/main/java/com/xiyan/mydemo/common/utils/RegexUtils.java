package com.xiyan.mydemo.common.utils;

import java.util.regex.Pattern;

/**
 * 正则表达式校验工具类
 * @Author xiyan
 * @Date 2020/6/11
 * @Version 1.0
 */
public class RegexUtils {
    private static final String REGEX_LOGINNAME="^[a-zA-Z0-9_-]{4,16}$";
    public static final String REGEX_LOGINNAME_ERROR="登录名仅支持4~16位字母、数字、下划线、减号";

    public static final String REGEX_USERNAME="^[a-zA-Z0-9_-]{4,16}$";
    public static final String REGEX_USERNAME_ERROR="用户名仅支持2~16位中英文、数字、减号或下划线";

    public static final String REGEX_PASSWORD="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z\\\\W]{6,16}$";
    public static final String REGEX_PASSWORD_ERROR="密码必须包含数字和字母，且在6~116位之间";

    /**
     * 校验登录名
     * 4到16位：字母，数字，下划线，减号
     * @param loginname
     * @return
     */
    public static Boolean checkLoginname(String loginname){
        String regex=REGEX_LOGINNAME;
        return Pattern.matches(regex,loginname);
    }

    /**
     * 校验用户名
     * 2到16位：中英文、数字、减号或下划线
     * @param username
     * @return
     */
    public static Boolean checkUsername(String username){
        String regex=REGEX_USERNAME;
        return Pattern.matches(regex,username);
    }

    /**
     * 校验密码
     * 6到20位：字母、数字、字符
     * @param password
     * @return
     */
    public static Boolean checkPasswprd(String password){
        String regex=REGEX_PASSWORD;
        return Pattern.matches(regex,password);
    }
}
