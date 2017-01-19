package com.github.developframework.wechat.pay.entity;

/**
 * 账单类型枚举
 */
public enum BillTypeEnum {

    ALL, //返回当日所有订单信息，默认值
    SUCCESS, //返回当日成功支付的订单
    REFUND, //返回当日退款订单
}
