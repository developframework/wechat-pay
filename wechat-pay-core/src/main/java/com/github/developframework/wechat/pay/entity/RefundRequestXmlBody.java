package com.github.developframework.wechat.pay.entity;

import com.github.developframework.wechat.pay.annotation.Sign;
import com.github.developframework.wechat.pay.core.RequestXmlBody;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 退款请求体<br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_4
 *
 * @author qiuzhenao
 */
@Getter
@Setter
@Sign
@XmlRootElement(name = "xml")
public class RefundRequestXmlBody extends RequestXmlBody{

    /* 微信支付订单号 */
    @XmlElement(name = "transaction_id")
    private String transactionId;

    /* 商户订单号 */
    @XmlElement(name = "out_trade_no")
    private String outTradeNo;

    /* 签名 */
    @XmlElement(name = "sign", required = true)
    private String sign;

    /* 商户退款单号 */
    @XmlElement(name = "out_refund_no", required = true)
    private String outRefundNo;

    /* 订单金额 */
    @XmlElement(name = "total_fee", required = true)
    private Integer totalFee;

    /* 退款金额 */
    @XmlElement(name = "refund_fee", required = true)
    private Integer refundFee;

    /* 货币种类 */
    @XmlElement(name = "refund_fee_type")
    private FeeTypeEnum refundFeeType;

    /* 操作员 */
    @XmlElement(name = "op_user_id")
    private String opUserId;

    /* 退款资金来源 */
    @XmlElement(name = "refund_account")
    private RefundAccountEnum refundAccount;

}
