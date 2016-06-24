package org.develop.wechatpay.converter;

import org.develop.wechatpay.entity.WechatPayNotifyResponseEntity;

/**
 * 支付结果通知响应转换器
 * 
 * @author qiuzhenhao
 *
 */
public class WechatPayNotifyResponseXmlConverter extends BaseAnnotationXmlConverter<WechatPayNotifyResponseEntity> {

	public String toXML(WechatPayNotifyResponseEntity t) {
		return super.toXML(t, null);
	}
}
