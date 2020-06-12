package com.xiyan.mydemo.common.config;

import com.xiyan.mydemo.common.utils.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 * @Author xiyan
 * @Date 2020/6/11
 * @Version 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获未知异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler
    public ApiResult unknowException(Exception e){
        log.info("未知异常："+e.getMessage());
        e.printStackTrace();//后台输出具体异常
        return ApiResult.unknowError();
    }

    /**
     * 捕获运行时异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ApiResult runtimeExceptionHandler(final RuntimeException e) {
        log.info("运行时异常："+e.getMessage());
        e.printStackTrace();//后台输出具体异常
        return ApiResult.runtimeError(e.getMessage());
    }

    /**
     * 捕获自定义异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ApiResult customExceptionHandler(final CustomException e) {
        log.info("自定义异常："+e.getMessage());
        e.printStackTrace();//后台输出具体异常
        return ApiResult.error(e.getMessage());
    }

}
