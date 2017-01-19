package com.github.developframework.wechat.pay.entity;

import com.github.developframework.wechat.pay.annotation.XmlElementArray;
import com.github.developframework.wechat.pay.core.ResponseXmlBody;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Administrator on 2016/9/21.
 */
@Getter
@Setter
public class RefundQueryResponseXmlBody extends ResponseXmlBody{

    /* 微信支付订单号 */
    @XmlElement(name = "transaction_id")
    private String transactionId;

    /* 商户订单号 */
    @XmlElement(name = "out_trade_no")
    private String outTradeNo;

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

    /* 退款笔数 */
    @XmlElement(name = "refund_count", required = true)
    private Integer refund_count;

    /* 退款项数组 */
    @XmlElementArray(indexElement = "refund_count")
    private Refund[] refunds;

    /* 退款资金来源 */
    @XmlElement(name = "refund_account")
    private RefundAccountEnum refundAccount;
}
