package org.develop.wechatpay.entity;

import org.develop.wechatpay.annotation.BindingConverter;
import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.converter.UnifiedOrderRequestXmlConverter;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一下单请求实体类 <br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1
 * 
 * @author qiuzhenhao
 * 
 */
@Getter
@Setter
@BindingConverter(UnifiedOrderRequestXmlConverter.class)
public class UnifiedOrderRequestEntity extends RequestEntity {

	private static final long serialVersionUID = -4813345279067710569L;

	/* 随机字符串 */
	@XmlElement(value = "nonce_str", notNull = true)
	private String nonceStr;

	/* 签名 */
	@XmlElement(value = "sign", notNull = true)
	private String sign;

	/* 商品描述 */
	@XmlElement(value = "body", notNull = true)
	private String body;

	/* 商品详情 */
	@XmlElement(value = "detail")
	private String detail;

	/* 附加数据 */
	@XmlElement(value = "attach")
	private String attach;

	/* 商户订单号 */
	@XmlElement(value = "out_trade_no", notNull = true)
	private String outTradeNo;

	/* 货币类型 */
	@XmlElement(value = "fee_type")
	private String feeType;

	/* 总金额 */
	@XmlElement(value = "total_fee", notNull = true)
	private Integer totalFee;

	/* 终端IP */
	@XmlElement(value = "spbill_create_ip", notNull = true)
	private String spbillCreateIp;

	/* 交易起始时间 */
	@XmlElement(value = "time_start")
	private String timeStart;

	/* 交易结束时间 */
	@XmlElement(value = "time_expire")
	private String timeExpire;

	/* 商品标记 */
	@XmlElement(value = "goods_tag")
	private String goodsTag;

	/* 通知地址 */
	@XmlElement(value = "notify_url", notNull = true)
	private String notifyUrl;

	/* 交易类型 */
	@XmlElement(value = "trade_type", notNull = true)
	private String tradeType;

	/* 商品ID */
	@XmlElement(value = "product_id")
	private String productId;

	/* 指定支付方式 */
	@XmlElement(value = "limit_pay")
	private String limitPay;

	/* 用户标识 */
	@XmlElement(value = "openid")
	private String openid;
}
