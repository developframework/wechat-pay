package org.develop.wechatpay.entity;

import org.develop.wechatpay.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnifiedOrderInfo {

	/* 交易类型 */
	@XmlElement("trade_type")
	private String tradeType;

	/* 预支付交易会话标识 */
	@XmlElement("prepay_id")
	private String prepayId;

	/* 二维码链接 */
	@XmlElement("code_url")
	private String codeUrl;
}