package com.xiyan.mydemo.common.utils;

import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装 Dozer 转换集合工具类
 * @Author xiyan
 * @Date 2020/6/11
 * @Version 1.0
 */
public class DozerUtils {

    /**
     * 封装dozer处理集合的方法：List<S> --> List<T>
     */
    public static <T, S> List<T> mapList(final Mapper mapper, List<S> sourceList, Class<T> targetObjectClass) {
        List<T> targetList = new ArrayList<T>();
        for (S s : sourceList) {
            targetList.add(mapper.map(s, targetObjectClass));
        }
        return targetList;
    }
}
