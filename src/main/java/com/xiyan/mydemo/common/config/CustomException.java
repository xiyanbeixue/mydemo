package com.xiyan.mydemo.common.config;

/**
 * 自定义异常类
 * @Author xiyan
 * @Date 2020/6/12
 * @Version 1.0
 */
public class CustomException extends RuntimeException{
    /**
     * 构造一个基本异常
     * @param message 异常信息
     */
    public CustomException(String message){
        super(message);
    }
}
