package org.develop.wechatpay;

import org.develop.wechatpay.annotation.BindingConverter;
import org.develop.wechatpay.converter.XmlConverter;
import org.develop.wechatpay.http.HttpResponse;
import org.develop.wechatpay.http.HttpSendable;
import org.develop.wechatpay.http.HttpSender;
import org.develop.wechatpay.utils.Util;

/**
 * API请求器
 * 
 * @author qiuzhenhao
 *
 */
public abstract class ApiRequestor extends HttpSender implements HttpSendable {

	/**
	 * 请求api得到响应xml实体
	 * 
	 * @param wechatConfiguration
	 * @param xmlConverter
	 * @param url
	 * @param request
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <REQUEST, RESPONSE> RESPONSE api(WechatConfiguration wechatConfiguration, String url, REQUEST request, Class<RESPONSE> clazz) {
		try {
			XmlConverter<REQUEST> xmlRequestConverter = request.getClass().getAnnotation(BindingConverter.class).value().newInstance();
			HttpResponse response = super.postHttps(url, xmlRequestConverter.toXML(request));
			if (response.isOK()) {
				XmlConverter<RESPONSE> xmlResponseConverter = clazz.getAnnotation(BindingConverter.class).value().newInstance();
				return xmlResponseConverter.toEntity(response.getContent(), clazz);
			}
		} catch (Exception e) {
			Util.catchException(e);
		}
		return null;
	}
}
