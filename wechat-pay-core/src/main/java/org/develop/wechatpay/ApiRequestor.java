package org.develop.wechatpay;

import org.develop.wechatpay.converter.BaseAnnotationXmlDeserializer;
import org.develop.wechatpay.converter.BaseAnnotationXmlSerializer;
import org.develop.wechatpay.converter.XmlDeserializer;
import org.develop.wechatpay.converter.XmlSerializer;
import org.develop.wechatpay.entity.RequestEntity;
import org.develop.wechatpay.entity.WechatEntity;
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
	protected <INFO> WechatEntity<INFO> api(WechatConfiguration wechatConfiguration, String url, RequestEntity request, Class<INFO> clazz) {
		try {
			XmlSerializer<RequestEntity> xmlRequestSerializer = new BaseAnnotationXmlSerializer<>();
			HttpResponse response = super.postHttps(url, xmlRequestSerializer.serialize(request, wechatConfiguration.getApiKey()));
			if (response.isOK()) {
				XmlDeserializer<INFO> xmlDeserializer = new BaseAnnotationXmlDeserializer<>();
				return xmlDeserializer.deserialize(response.getContent(), clazz);
			}
		} catch (Exception e) {
			Util.catchException(e);
		}
		return null;
	}
}
