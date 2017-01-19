package com.github.developframework.wechat.pay.entity;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * 代金券
 */
@Getter
@ToString
public class Coupon implements Serializable {

    /* 代金券批次ID */
    @XmlElement(name = "coupon_batch_id_$n")
    private Integer couponBatchId;

    /* 代金券类型 */
    @XmlElement(name = "coupon_type_$n")
    private String couponType;

    /* 代金券ID */
    @XmlElement(name = "coupon_id_$n")
    private Integer couponId;

    /* 单个代金券支付金额 */
    @XmlElement(name = "coupon_fee_$n")
    private Integer couponFee;
}
