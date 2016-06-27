package org.develop.spring.resolver;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.develop.wechatpay.converter.BaseAnnotationXmlDeserializer;
import org.develop.wechatpay.converter.XmlDeserializer;
import org.develop.wechatpay.entity.WechatEntity;
import org.develop.wechatpay.entity.WechatPayNotifyInfo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 微信支付通知回调参数分解器
 * 
 * @author qiuzhenhao
 *
 */
public class WechatPayNotifyArgumentResolver implements HandlerMethodArgumentResolver {

	private XmlDeserializer<WechatPayNotifyInfo> deserializer = new BaseAnnotationXmlDeserializer<>();

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(WechatEntity.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		String xml = new String(IOUtils.toByteArray(request.getInputStream()));
		return deserializer.deserialize(xml, WechatPayNotifyInfo.class);
	}

}
