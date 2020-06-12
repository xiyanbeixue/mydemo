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

    public static ApiResult success() {
        return new ApiResult(Boolean.TRUE,200,"操作成功");
    }

    public static ApiResult success(Object data) {
        return new ApiResult(Boolean.TRUE,200,"操作成功",data);
    }

    /**
     * 操作失败
     * @param msg 失败原因
     * @return
     */
    public static ApiResult error(String msg) {
        return new ApiResult(Boolean.FALSE,201,msg);
    }

    public static ApiResult unknowError() {
        return new ApiResult(Boolean.FALSE,500,"系统发生未知异常，请联系管理员");
    }
    public static ApiResult runtimeError(String msg) {
        return new ApiResult(Boolean.FALSE,400,msg);
    }
}
