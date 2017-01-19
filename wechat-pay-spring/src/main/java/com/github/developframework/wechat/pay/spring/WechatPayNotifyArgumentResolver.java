package com.github.developframework.wechat.pay.spring;

import com.github.developframework.wechat.pay.core.WechatPayBody;
import com.github.developframework.wechat.pay.entity.WechatPayNotifyBody;
import com.github.developframework.wechat.pay.exception.PrepareCheckSignFailedException;
import com.github.developframework.wechat.pay.utils.SignUtils;
import com.github.developframework.wechat.pay.xml.BaseAnnotationXmlDeserializer;
import com.github.developframework.wechat.pay.xml.XmlDeserializer;
import lombok.Setter;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信支付通知回调参数分解器
 * 
 * @author qiuzhenhao
 *
 */
public class WechatPayNotifyArgumentResolver implements HandlerMethodArgumentResolver {

	private XmlDeserializer<WechatPayNotifyBody> deserializer = new BaseAnnotationXmlDeserializer<>();

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(WechatPayBody.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		String xml = new String(IOUtils.toByteArray(request.getInputStream()));
		return deserializer.deserialize(xml, WechatPayNotifyBody.class);
	}

}
