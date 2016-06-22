package org.develop.wechatpay.entity;

import org.develop.wechatpay.annotation.BindingConverter;
import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.converter.WechatPayNotifyResponseXmlConverter;

import lombok.Getter;
import lombok.Setter;

/**
 * 支付结果通知响应实体<br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7
 * 
 * @author qiuzhenhao
 *
 */
@Getter
@Setter
@BindingConverter(WechatPayNotifyResponseXmlConverter.class)
public class WechatPayNotifyResponseEntity {

	/* 返回状态码 */
	@XmlElement("return_code")
	private String returnCode;

	/* 返回信息 */
	@XmlElement("return_msg")
	private String returnMsg;
}
