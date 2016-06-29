package org.develop.wechatpay.entity;

import java.io.Serializable;

import org.develop.wechatpay.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnifiedOrderInfo implements Serializable {

	private static final long serialVersionUID = -8307374320477267800L;

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