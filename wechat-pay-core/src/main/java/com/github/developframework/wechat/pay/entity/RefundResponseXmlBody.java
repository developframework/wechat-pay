package com.github.developframework.wechat.pay.entity;

import com.github.developframework.wechat.pay.core.ResponseXmlBody;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

/**
 * 退款响应体
 */
@Getter
@Setter
public class RefundResponseXmlBody extends ResponseXmlBody{

    /* 微信支付订单号 */
    @XmlElement(name = "transaction_id")
    private String transactionId;

    /* 商户订单号 */
    @XmlElement(name = "out_trade_no")
    private String outTradeNo;

    /* 商户退款单号 */
    @XmlElement(name = "out_refund_no", required = true)
    private String outRefundNo;

    /* 微信退款单号 */
    @XmlElement(name = "refund_id", required = true)
    private String refundId;

    /* 退款渠道 */
    @XmlElement(name = "refund_channel", required = true)
    private RefundChannelEnum refundChannel;

    /* 申请退款金额 */
    @XmlElement(name = "refund_fee", required = true)
    private Integer refundFee;

    /* 退款金额 */
    @XmlElement(name = "settlement_refund_fee")
    private Integer settlementRefundFee;

    /* 订单金额 */
    @XmlElement(name = "total_fee", required = true)
    private Integer totalFee;

    /* 应结订单金额 */
    @XmlElement(name = "settlement_total_fee")
    private Integer settlementTotalFee;

    /* 订单金额货币种类 */
    @XmlElement(name = "fee_type")
    private FeeTypeEnum feeType;

    /* 现金支付金额 */
    @XmlElement(name = "cash_fee", required = true)
    private Integer cashFee;

    /* 现金退款金额 */
    @XmlElement(name = "cashRefundFee")
    private Integer cash_refund_fee;

}
