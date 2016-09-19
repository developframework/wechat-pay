package com.github.developframework.wechat.pay.entity;

import com.github.developframework.wechat.pay.annotation.Sign;
import com.github.developframework.wechat.pay.core.RequestXmlBody;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 查询订单请求体<br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_2
 *
 * @author qiuzhenao
 */
@Getter
@Setter
@Sign
@XmlRootElement(name = "xml")
public class OrderQueryRequestXmlBody extends RequestXmlBody {

    /* 微信支付订单号 */
    @XmlElement(name = "transaction_id")
    private String transactionId;

    /* 商户订单号 */
    @XmlElement(name = "out_trade_no")
    private String outTradeNo;

    /* 签名 */
    @XmlElement(name = "sign", required = true)
    private String sign;
}
