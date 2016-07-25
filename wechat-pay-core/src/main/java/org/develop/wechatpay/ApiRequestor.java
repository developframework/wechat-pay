package org.develop.wechatpay;

import org.develop.wechatpay.converter.BaseAnnotationXmlDeserializer;
import org.develop.wechatpay.converter.BaseAnnotationXmlSerializer;
import org.develop.wechatpay.converter.XmlDeserializer;
import org.develop.wechatpay.converter.XmlSerializer;
import org.develop.wechatpay.entity.RequestEntity;
import org.develop.wechatpay.entity.WechatEntity;
import org.develop.wechatpay.exception.CheckSignFailedException;
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
		HttpResponse response = null;
		try {
			XmlSerializer<RequestEntity> xmlRequestSerializer = new BaseAnnotationXmlSerializer<>();
			response = super.postHttps(url, xmlRequestSerializer.serialize(request, wechatConfiguration.getApiKey()));
		} catch (Exception e) {
			Util.catchException(e);
		}
		if (response.isOK()) {
			XmlDeserializer<INFO> xmlDeserializer = new BaseAnnotationXmlDeserializer<>();
			WechatEntity<INFO> wechatEntity = xmlDeserializer.deserialize(response.getContent(), clazz);
			if (!Util.checkSign(wechatEntity, wechatConfiguration.getApiKey(), wechatEntity.getReturnSuccessResponse().getSign())) {
				throw new CheckSignFailedException();
			}
		}
		return null;
	}
}
