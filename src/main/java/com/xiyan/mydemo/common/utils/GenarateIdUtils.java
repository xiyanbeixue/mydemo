package com.xiyan.mydemo.common.utils;

public class GenarateIdUtils {
    //这里的0，0分别是      * @param workerId 工作ID (0~31)     * @param datacenterId 数据中心ID (0~31)，可以写在配置文件中。
    private static SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

    public static GenarateIdUtils getInstance() {
        return new GenarateIdUtils();
    }

    /**
     * 生成18位订单编号
     */
    public static Long getOrderNumber() {
        return idWorker.nextId();
    }

    /**
     * 生成18位退款编号
     */
    public static Long getRefundNumber() {
        return idWorker.nextId();
    }

    /**
     * 生成18位userId
     * @return
     */
    public static Long getUserId() {
        return idWorker.nextId();
    }
}
