package org.develop.wechatpay.entity;

import java.io.Serializable;

import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.annotation.XmlElementArray;

/**
 * 查询订单响应体
 * 
 * @author qiuzhenhao
 *
 */
public class OrderQueryInfo implements Serializable {

	private static final long serialVersionUID = -2358340680866424901L;
	/* 用户标识 */
	@XmlElement(value = "device_info")
	private String deviceInfo;

	/* 用户标识 */
	@XmlElement(value = "openid", notNull = true)
	private String openid;

	/* 是否关注公众账号 */
	@XmlElement(value = "is_subscribe")
	private String isSubscribe;

	/* 交易类型 */
	@XmlElement(value = "trade_type", notNull = true)
	private String tradeType;

	/* 交易状态 */
	@XmlElement(value = "trade_state", notNull = true)
	private String tradeState;

	/* 付款银行 */
	@XmlElement(value = "bank_type", notNull = true)
	private String bankType;

	/* 订单金额 */
	@XmlElement(value = "total_fee", notNull = true)
	private String totalFee;

	/* 应结订单金额 */
	@XmlElement(value = "settlement_total_fee")
	private String settlementTotalFee;

	/* 货币种类 */
	@XmlElement(value = "fee_type")
	private String feeType;

	/* 现金支付金额 */
	@XmlElement(value = "cash_fee", notNull = true)
	private Integer cashFee;

	/* 现金支付货币类型 */
	@XmlElement(value = "cash_fee_type")
	private String cashFeeType;

	/* 代金券金额 */
	@XmlElement(value = "coupon_fee")
	private Integer couponFee;

	/* 代金券使用数量 */
	@XmlElement(value = "coupon_count")
	private Integer couponCount;

	/* 代金券批次ID */
	@XmlElementArray(value = "coupon_batch_id_$n", indexElement = "coupon_count")
	private Integer[] couponBatchIdArray;

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
	@XmlElement(value = "transaction_id", notNull = true)
	private String transactionId;

	/* 商户订单号 */
	@XmlElement(value = "out_trade_no", notNull = true)
	private String outTradeNo;

	/* 商家数据包 */
	@XmlElement(value = "attach")
	private String attach;

	/* 支付完成时间 */
	@XmlElement(value = "time_end", notNull = true)
	private String timeEnd;

	/* 交易状态描述 */
	@XmlElement(value = "trade_state_desc", notNull = true)
	private String tradeStateDesc;
}
