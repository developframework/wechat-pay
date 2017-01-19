package com.github.developframework.wechat.pay.spring;

import com.github.developframework.wechat.pay.entity.WechatPayNotifyResponseBody;
import com.github.developframework.wechat.pay.xml.BaseAnnotationXmlSerializer;
import com.github.developframework.wechat.pay.xml.XmlSerializer;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;

/**
 * 响应微信支付通知的返回对象处理器
 * 
 * @author qiuzhenhao
 *
 */
public class WechatPayNotifyResponseProcessor implements HandlerMethodReturnValueHandler {

	private XmlSerializer<WechatPayNotifyResponseBody> serializer = new BaseAnnotationXmlSerializer<>();

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return returnType.getParameterType().equals(WechatPayNotifyResponseBody.class);
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
		Assert.isInstanceOf(WechatPayNotifyResponseBody.class, returnValue);
		mavContainer.setRequestHandled(true);
		ServletServerHttpResponse outputMessage = createOutputMessage(webRequest);
		String xml = serializer.serialize((WechatPayNotifyResponseBody) returnValue);
		outputMessage.setStatusCode(HttpStatus.OK);
		outputMessage.getHeaders().add("Content-Type", "application/xml;charset=utf-8");
		IOUtils.write(xml, outputMessage.getBody(), "utf-8");
	}

	protected ServletServerHttpResponse createOutputMessage(NativeWebRequest webRequest) {
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		return new ServletServerHttpResponse(response);
	}

}
