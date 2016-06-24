package org.develop.spring.resolver;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.develop.wechatpay.converter.WechatPayNotifyRequestXmlConverter;
import org.develop.wechatpay.entity.WechatPayNotifyRequestEntity;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class WechatPayNotifyArgumentResolver implements HandlerMethodArgumentResolver {

	private WechatPayNotifyRequestXmlConverter converter = new WechatPayNotifyRequestXmlConverter();

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(WechatPayNotifyRequestEntity.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		String xml = new String(IOUtils.toByteArray(request.getInputStream()));
		return converter.toEntity(xml, WechatPayNotifyRequestEntity.class);
	}

}
