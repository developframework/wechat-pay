package com.github.developframework.wechat.pay.entity;

import com.github.developframework.wechat.pay.annotation.XmlElementArray;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 支付结果通知请求实体<br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7
 * 
 * @author qiuzhenhao
 *
 */
@Getter
@Setter
public class WechatPayNotifyBody implements Serializable {

	private static final long serialVersionUID = -4409171673622276808L;

	/* 用户标识 */
	@XmlElement(name = "openid", required = true)
	private String openid;

	/* 是否关注公众账号 */
	@XmlElement(name = "is_subscribe")
	private String isSubscribe;

	/* 交易类型 */
	@XmlElement(name = "trade_type", required = true)
	private String tradeType;

	/* 付款银行 */
	@XmlElement(name = "bank_type", required = true)
	private String bankType;

	/* 订单金额 */
	@XmlElement(name = "total_fee", required = true)
	private Integer totalFee;

	/* 应结订单金额 */
	@XmlElement(name = "settlement_total_fee")
	private Integer settlementTotalFee;

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

}
