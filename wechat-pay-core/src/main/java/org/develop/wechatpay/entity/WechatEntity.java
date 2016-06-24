package org.develop.wechatpay.entity;

import java.io.Serializable;

import org.develop.wechatpay.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

/**
 * 响应体
 * 
 * @author qiuzhenhao
 *
 */
@Getter
@Setter
public class WechatEntity<T> implements Serializable {

	private static final long serialVersionUID = -2830599944906856244L;

	/* 返回状态码 */
	@XmlElement("return_code")
	private String returnCode;

	/* 返回信息 */
	@XmlElement("return_msg")
	private String returnMsg;

	private T information;

	public boolean isReturnSuccess() {
		return "SUCCESS".equals(returnCode);
	}
}
