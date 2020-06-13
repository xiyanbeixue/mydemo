package com.xiyan.mydemo.common.config;

import com.xiyan.mydemo.common.utils.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @Author xiyan
 * @Date 2020/6/11
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获系统异常
     * @param e
     * @return
     */
    @ExceptionHandler
    public ApiResult exception(Exception e){
        log.error("系统异常："+e.getMessage());
        e.printStackTrace();
        return ApiResult.systemError(e.getMessage());
    }

    /**
     * 捕获运行时异常
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ApiResult runtimeExceptionHandler(final RuntimeException e) {
        log.error("运行时异常："+e.getMessage());
        e.printStackTrace();
        return ApiResult.runtimeError(e.getMessage());
    }

    /**
     * 捕获自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ApiResult customExceptionHandler(final CustomException e) {
        log.error("自定义异常："+e.getMessage());
        e.printStackTrace();
        return ApiResult.error(e.getMessage());
    }

    /**
     * 捕获参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult validExceptionHandler(MethodArgumentNotValidException e){
        log.error("参数校验异常"+e.getBindingResult().getFieldError().getDefaultMessage());
        e.printStackTrace();
        return ApiResult.validError(e.getBindingResult().getFieldError().getDefaultMessage());
    }

}
