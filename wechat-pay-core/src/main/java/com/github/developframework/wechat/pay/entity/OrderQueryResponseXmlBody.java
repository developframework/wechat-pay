package com.github.developframework.wechat.pay.entity;

import com.github.developframework.wechat.pay.annotation.XmlElementArray;
import com.github.developframework.wechat.pay.core.ResponseXmlBody;

import javax.xml.bind.annotation.XmlElement;

/**
 * 查询订单响应体
 * 
 * @author qiuzhenhao
 *
 */
public class OrderQueryResponseXmlBody extends ResponseXmlBody {

	/* 用户标识 */
	@XmlElement(name = "device_info")
	private String deviceInfo;

	/* 用户标识 */
	@XmlElement(name = "openid", required = true)
	private String openid;

	/* 是否关注公众账号 */
	@XmlElement(name = "is_subscribe")
	private String isSubscribe;

	/* 交易类型 */
	@XmlElement(name = "trade_type", required = true)
	private TradeTypeEnum tradeType;

	/* 交易状态 */
	@XmlElement(name = "trade_state", required = true)
	private String tradeState;

	/* 付款银行 */
	@XmlElement(name = "bank_type", required = true)
	private BankTypeEnum bankType;

	/* 订单金额 */
	@XmlElement(name = "total_fee", required = true)
	private Integer totalFee;

	/* 应结订单金额 */
	@XmlElement(name = "settlement_total_fee")
	private String settlementTotalFee;

	/* 货币种类 */
	@XmlElement(name = "fee_type")
	private String feeType;

	/* 现金支付金额 */
	@XmlElement(name = "cash_fee", required = true)
	private Integer cashFee;

	/* 现金支付货币类型 */
	@XmlElement(name = "cash_fee_type")
	private String cashFeeType;

	/* 代金券金额 */
	@XmlElement(name = "coupon_fee")
	private Integer couponFee;

	/* 代金券使用数量 */
	@XmlElement(name = "coupon_count")
	private Integer couponCount;

	/* 代金券数组 */
	@XmlElementArray(indexElement = "coupon_count")
	private Coupon[] coupons;

	/* 微信支付订单号 */
	@XmlElement(name = "transaction_id", required = true)
	private String transactionId;

	/* 商户订单号 */
	@XmlElement(name = "out_trade_no", required = true)
	private String outTradeNo;

	/* 商家数据包 */
	@XmlElement(name = "attach")
	private String attach;

	/* 支付完成时间 */
	@XmlElement(name = "time_end", required = true)
	private String timeEnd;

	/* 交易状态描述 */
	@XmlElement(name = "trade_state_desc", required = true)
	private String tradeStateDesc;
}
