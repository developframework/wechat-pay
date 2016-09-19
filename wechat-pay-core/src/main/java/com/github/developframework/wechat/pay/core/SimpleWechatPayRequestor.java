package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.utils.SignUtils;
import com.github.developframework.wechat.pay.xml.XmlProcessor;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Administrator on 2016/9/6.
 */
public class SimpleWechatPayRequestor<REQUEST extends RequestXmlBody, RESPONSE extends ResponseXmlBody> implements WechatPayRequestor<REQUEST, RESPONSE> {

    private XmlProcessor<REQUEST, RESPONSE> xmlProcessor;

    private WechatPayConfiguration configuration;

    public SimpleWechatPayRequestor(XmlProcessor<REQUEST, RESPONSE> xmlProcessor, WechatPayConfiguration configuration) {
        this.xmlProcessor = xmlProcessor;
        this.configuration = configuration;
    }

    @Override
    public WechatPayBody<RESPONSE> request(REQUEST body) {
        body.setAppid(configuration.getAppid());
        body.setMchId(configuration.getMchId());
        body.setNonceStr(RandomStringUtils.randomAlphabetic(20));
        SignUtils.bindSign(body, configuration.getApiKey());
        return xmlProcessor.process(configuration, body);
    }
}
