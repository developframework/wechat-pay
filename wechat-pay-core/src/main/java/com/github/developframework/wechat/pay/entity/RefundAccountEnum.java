package com.github.developframework.wechat.pay.entity;

/**
 * 退款资金来源枚举
 */
public enum RefundAccountEnum {

    REFUND_SOURCE_RECHARGE_FUNDS, //可用余额退款/基本账户
    REFUND_SOURCE_UNSETTLED_FUNDS //未结算资金退款
}
