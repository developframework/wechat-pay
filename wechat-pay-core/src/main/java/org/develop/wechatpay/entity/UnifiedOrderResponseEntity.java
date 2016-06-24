package org.develop.wechatpay.entity;

import org.develop.wechatpay.annotation.BindingConverter;
import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.converter.UnifiedOrderResponseXmlConverter;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一下单响应实体类 <br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1
 * 
 * @author qiuzhenhao
 *
 */
@Getter
@Setter
@BindingConverter(UnifiedOrderResponseXmlConverter.class)
public class UnifiedOrderResponseEntity extends ResponseEntity {

	private static final long serialVersionUID = -1742370637949386039L;

	/* 返回状态码 */
	@XmlElement("return_code")
	protected String returnCode;

	/* 返回信息 */
	@XmlElement("return_msg")
	protected String returnMsg;
}
