package com.github.developframework.wechat.pay.entity;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * 退款
 */
@Getter
@ToString
public class Refund implements Serializable {

    /* 商户退款单号 */
    @XmlElement(name = "out_refund_no_$n", required = true)
    private String outRefundNo;

    /* 微信退款单号 */
    @XmlElement(name = "refund_id_$n", required = true)
    private String refundId;

    /* 退款渠道 */
    @XmlElement(name = "refund_channel_$n")
    private RefundChannelEnum refundChannel;

    /* 申请退款金额 */
    @XmlElement(name = "refund_fee_$n", required = true)
    private Integer refundFee;

    /* 退款金额 */
    @XmlElement(name = "settlement_refund_fee_$n")
    private Integer settlementRefundFee;

    /* 退款状态 */
    @XmlElement(name = "refund_status_$n", required = true)
    private RefundStatusEnum refundStatus;

    /* 退款入账账户 */
    @XmlElement(name = "refund_recv_accout_$n", required = true)
    private String refundRecvAccout;




}
