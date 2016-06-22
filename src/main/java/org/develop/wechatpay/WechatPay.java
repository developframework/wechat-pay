package org.develop.wechatpay;

import org.develop.wechatpay.converter.WechatPayNotifyRequestXmlConverter;
import org.develop.wechatpay.converter.WechatPayNotifyResponseXmlConverter;
import org.develop.wechatpay.entity.WechatPayNotifyRequestEntity;
import org.develop.wechatpay.entity.WechatPayNotifyResponseEntity;
import org.develop.wechatpay.utils.Assert;
import org.develop.wechatpay.utils.PropertyUtils;

/**
 * 微信支付
 * 
 * @author qiuzhenhao
 *
 */
public final class WechatPay {

	/* 默认的配置文件 */
	public static final String DEFAULT_PROPERTIES = "/wechat-pay.properties";

	/**
	 * 创建客户端
	 * 
	 * @return
	 */
	public static WechatPayApiClient createClient() {
		return createClient(DEFAULT_PROPERTIES);
	}

	/**
	 * 创建客户端
	 * 
	 * @param propertyfilename
	 * @return
	 */
	public static WechatPayApiClient createClient(String propertyfilename) {

		WechatConfiguration wechatConfiguration = PropertyUtils.readProperties(propertyfilename, WechatConfiguration.class);

		Assert.nonBlank(wechatConfiguration.getAppid(), "wechat.info.appid undefined");
		Assert.nonBlank(wechatConfiguration.getMchId(), "wechat.info.mch_id undefined");

		return new WechatPayApiClient(wechatConfiguration);
	}

	/**
	 * 解析微信支付系统的支付通知
	 * 
	 * @param xml
	 * @return
	 */
	public static WechatPayNotifyRequestEntity parseWechatPayNotify(String xml) {
		Assert.nonBlank(xml, "xml is required!");
		WechatPayNotifyRequestXmlConverter converter = new WechatPayNotifyRequestXmlConverter();
		return converter.toEntity(xml, WechatPayNotifyRequestEntity.class);
	}

	/**
	 * 生成响应通知的XML
	 * 
	 * @param entity
	 * @return
	 */
	public static String makeResponseForNotify(WechatPayNotifyResponseEntity entity) {
		Assert.nonNull(entity);
		Assert.nonBlank(entity.getReturnCode(), "returnCode is required!");
		WechatPayNotifyResponseXmlConverter converter = new WechatPayNotifyResponseXmlConverter();
		return converter.toXML(entity);
	}

}
