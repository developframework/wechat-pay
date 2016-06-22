package org.develop.wechatpay.entity;

import org.develop.wechatpay.annotation.BindingConverter;
import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.annotation.XmlElementArray;
import org.develop.wechatpay.converter.WechatPayNotifyRequestXmlConverter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@BindingConverter(WechatPayNotifyRequestXmlConverter.class)
public class WechatPayNotifyRequestEntity {

	/* 公众账号ID */
	@XmlElement("appid")
	private String appid;

	/* 商户号 */
	@XmlElement("mch_id")
	private String mchId;

	/* 设备号 */
	@XmlElement(value = "device_info", notNull = true)
	private String deviceInfo;

	/* 随机字符串 */
	@XmlElement("nonce_str")
	private String nonceStr;

	/* 签名 */
	@XmlElement("sign")
	private String sign;

	/* 业务结果 */
	@XmlElement("result_code")
	private String resultCode;

	/* 错误代码 */
	@XmlElement(value = "err_code", notNull = true)
	private String errCode;

	/* 错误代码描述 */
	@XmlElement(value = "err_code_des", notNull = true)
	private String errCodeDes;

	/* 用户标识 */
	@XmlElement("openid")
	private String openid;

	/* 是否关注公众账号 */
	@XmlElement(value = "is_subscribe", notNull = true)
	private String isSubscribe;

	/* 交易类型 */
	@XmlElement("trade_type")
	private String tradeType;

	/* 付款银行 */
	@XmlElement("bank_type")
	private String bankType;

	/* 订单金额 */
	@XmlElement("total_fee")
	private String totalFee;

	/* 应结订单金额 */
	@XmlElement(value = "settlement_total_fee", notNull = true)
	private String settlementTotalFee;

	/* 货币种类 */
	@XmlElement(value = "fee_type", notNull = true)
	private String feeType;

	/* 现金支付金额 */
	@XmlElement("cash_fee")
	private Integer cashFee;

	/* 现金支付货币类型 */
	@XmlElement(value = "cash_fee_type", notNull = true)
	private String cashFeeType;

	/* 代金券金额 */
	@XmlElement(value = "coupon_fee", notNull = true)
	private Integer couponFee;

	/* 代金券使用数量 */
	@XmlElement(value = "coupon_count", notNull = true)
	private Integer couponCount;

	/* 代金券类型 */
	@XmlElementArray(value = "coupon_type_$n", indexElement = "coupon_count")
	private Integer[] couponTypeArray;

	/* 代金券ID */
	@XmlElementArray(value = "coupon_id_$n", indexElement = "coupon_count")
	private String[] couponIdArray;

	/* 单个代金券支付金额 */
	@XmlElementArray(value = "coupon_fee_$n", indexElement = "coupon_count")
	private Integer[] couponFeeArray;

	/* 微信支付订单号 */
	@XmlElement("transaction_id")
	private String transactionId;

	/* 商户订单号 */
	@XmlElement("out_trade_no")
	private String outTradeNo;

	/* 商家数据包 */
	@XmlElement(value = "attach", notNull = true)
	private String attach;

	/* 支付完成时间 */
	@XmlElement("time_end")
	private String timeEnd;

}
