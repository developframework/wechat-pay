package org.develop.wechatpay.entity;

import java.io.Serializable;

import org.develop.wechatpay.annotation.SignElement;
import org.develop.wechatpay.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询订单请求体<br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_2
 * 
 * @author qiuzhenao
 *
 */
@Getter
@Setter
public class OrderQueryRequestEntity implements Serializable {

	private static final long serialVersionUID = -5401415320658743354L;

	/* 公众账号ID */
	@XmlElement(value = "appid")
	private String appid;

	/* 商户号 */
	@XmlElement(value = "mch_id")
	private String mchId;

	/* 微信支付订单号 */
	@XmlElement(value = "transaction_id")
	private String transactionId;

	/* 商户订单号 */
	@XmlElement(value = "out_trade_no")
	private String outTradeNo;

	/* 随机字符串 */
	@XmlElement(value = "nonce_str", notNull = true)
	private String nonceStr;

	/* 签名 */
	@SignElement
	@XmlElement(value = "sign", notNull = true)
	private String sign;
}
