package com.github.developframework.wechat.pay.entity;

/**
 * 退款状态枚举
 */
public enum RefundStatusEnum {

    SUCCESS, //退款成功
    FAIL, //退款失败
    PROCESSING, //退款处理中
    NOTSURE, //未确定，需要商户原退款单号重新发起
    CHANGE  //转入代发，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，资金回流到商户的现金帐号，需要商户人工干预，通过线下或者财付通转账的方式进行退款。
}
