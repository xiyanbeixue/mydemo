package com.xiyan.mydemo.common.utils;

import lombok.Data;

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

    public static ApiResult error(String msg) {
        return new ApiResult(Boolean.FALSE,201,msg);
    }
}
