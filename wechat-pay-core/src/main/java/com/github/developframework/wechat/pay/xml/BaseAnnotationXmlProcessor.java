package com.github.developframework.wechat.pay.xml;

import com.github.developframework.wechat.pay.core.WechatPayClientListener;
import com.github.developframework.wechat.pay.core.WechatPayConfiguration;
import com.github.developframework.wechat.pay.core.RequestXmlBody;
import com.github.developframework.wechat.pay.core.ResponseXmlBody;
import com.github.developframework.wechat.pay.core.WechatPayBody;
import com.github.developframework.wechat.pay.exception.PrepareCheckSignFailedException;
import com.github.developframework.wechat.pay.http.HttpResponse;
import com.github.developframework.wechat.pay.http.HttpSendable;
import com.github.developframework.wechat.pay.utils.SignUtils;
import lombok.Getter;

import java.util.Optional;

/**
 * 基于注解的处理器
 */
public class BaseAnnotationXmlProcessor<REQUEST extends RequestXmlBody, RESPONSE extends ResponseXmlBody> extends XmlProcessor<REQUEST, RESPONSE> implements HttpSendable {

    @Getter
    private String url;

    @Getter
    private Class<RESPONSE> responseBodyClass;

    @Getter
    private Optional<WechatPayClientListener> listenerOptional;

    public BaseAnnotationXmlProcessor(String url, Class<RESPONSE> responseBodyClass, WechatPayClientListener listener) {
        super(new BaseAnnotationXmlSerializer<>(), new BaseAnnotationXmlDeserializer<>());
        this.url = url;
        this.responseBodyClass = responseBodyClass;
        this.listenerOptional = Optional.ofNullable(listener);
    }

    @Override
    public WechatPayBody<RESPONSE> process(final WechatPayConfiguration configuration, REQUEST requestXmlBody) {
        final String xml = xmlSerializer.serialize(requestXmlBody);
        try {
            HttpResponse httpResponse = super.postHttps(url, xml);
            if (httpResponse.isOK()) {
                // http请求成功
                listenerOptional.ifPresent(listener -> listener.httpSuccess(configuration, httpResponse));
                boolean isPrepareCheckSignPass = SignUtils.prepareCheckSign(httpResponse.getContent(), configuration.getApiKey(), WechatPayBody.class);
                if(isPrepareCheckSignPass) {
                    return xmlDeserializer.deserialize(httpResponse.getContent(), responseBodyClass);
                } else {
                    // 预校验签名失败
                    if(listenerOptional.isPresent()) {
                        listenerOptional.get().prepareCheckSignFailed(configuration, httpResponse);
                    } else {
                        throw new PrepareCheckSignFailedException();
                    }
                }
            } else {
                // http请求失败
                listenerOptional.ifPresent(listener -> listener.httpFailed(configuration, httpResponse));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
