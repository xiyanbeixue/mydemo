package com.xiyan.mydemo.common.utils;

import lombok.Data;

/**
 * 封装返回参数工具类
 * @Author xiyan
 * @Date 2020/6/11
 * @Version 1.0
 */
@Data
public class ApiResult {
    private Boolean flag;
    private Integer code;
    private String msg;
    private Object data;

    public ApiResult(Boolean flag, Integer code, String msg, Object data) {
        super();
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ApiResult(Boolean flag, Integer code, String msg) {
        super();
        this.flag = flag;
        this.code = code;
        this.msg = msg;
    }

    /**
     * 操作成功（不带data）
     * @return
     */
    public static ApiResult success() {
        return new ApiResult(Boolean.TRUE,200,"操作成功");
    }

    /**
     * 操作成功（带data）
     * @param data
     * @return
     */
    public static ApiResult success(Object data) {
        return new ApiResult(Boolean.TRUE,200,"操作成功",data);
    }

    /**
     * 数据操作异常（一般在服务层抛出的异常）
     * @param msg 异常信息
     * @return
     */
    public static ApiResult error(String msg) {
        return new ApiResult(Boolean.FALSE,201,msg);
    }

    /**
     * 参数校验异常（一般在控制层校验的异常）
     * @param msg 异常信息
     * @return
     */
    public static ApiResult validError(String msg){
        return new ApiResult(Boolean.FALSE,202,msg);
    }

    /**
     * 除已捕获异常外所有的系统异常
     * @param msg
     * @return
     */
    public static ApiResult systemError(String msg) {
        return new ApiResult(Boolean.FALSE,500,"系统发生未知异常，请联系管理员；异常原因："+msg);
    }

    /**
     * 运行时异常
     * @param msg
     * @return
     */
    public static ApiResult runtimeError(String msg) {
        return new ApiResult(Boolean.FALSE,400,msg);
    }

}
