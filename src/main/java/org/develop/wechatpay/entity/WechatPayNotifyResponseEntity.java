package org.develop.wechatpay.entity;

import org.develop.wechatpay.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WechatPayNotifyResponseEntity {

	/* 返回状态码 */
	@XmlElement("return_code")
	private String returnCode;

	/* 返回信息 */
	@XmlElement("return_msg")
	private String returnMsg;
}
