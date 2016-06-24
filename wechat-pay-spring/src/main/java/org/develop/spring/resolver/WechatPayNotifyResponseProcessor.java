package org.develop.spring.resolver;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.develop.wechatpay.converter.BaseAnnotationXmlSerializer;
import org.develop.wechatpay.converter.XmlSerializer;
import org.develop.wechatpay.entity.WechatPayNotifyResponseEntity;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 响应微信支付通知的返回对象处理器
 * 
 * @author qiuzhenhao
 *
 */
public class WechatPayNotifyResponseProcessor implements HandlerMethodReturnValueHandler {

	private XmlSerializer<WechatPayNotifyResponseEntity> serializer = new BaseAnnotationXmlSerializer<>();

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return returnType.getParameterType() == WechatPayNotifyResponseEntity.class;
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
		Assert.isInstanceOf(WechatPayNotifyResponseEntity.class, returnValue);
		mavContainer.setRequestHandled(true);
		ServletServerHttpResponse outputMessage = createOutputMessage(webRequest);
		String xml = serializer.serialize((WechatPayNotifyResponseEntity) returnValue, null);
		outputMessage.setStatusCode(HttpStatus.OK);
		outputMessage.getHeaders().add("Content-Type", "application/xml;charset=utf-8");
		IOUtils.write(xml, outputMessage.getBody(), "utf-8");
	}

	protected ServletServerHttpResponse createOutputMessage(NativeWebRequest webRequest) {
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		return new ServletServerHttpResponse(response);
	}

}
